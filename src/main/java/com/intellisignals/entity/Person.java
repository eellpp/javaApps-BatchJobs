package com.intellisignals.entity;

import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.DataSerializable;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by eellpp on 25/3/18.
 */
public class Person  implements DataSerializable{

    public String name;
    public  int age;
    public String address;

    private List<String> list = Arrays.asList("Name1","sdfsdf","123123123","23","werwerwer","sdfsdsdf","ermgk");
    private Random random = new Random();
    public Person(){
        Collections.shuffle(list);
        name = list.stream().limit(2).collect(Collectors.joining("_"));
        address =  list.stream().limit(4).collect(Collectors.joining("_"));
        age = random.nextInt(100);

    }


    public void writeData(ObjectDataOutput objectDataOutput) throws IOException {
        objectDataOutput.writeUTF(name);
        objectDataOutput.writeUTF(address);
        objectDataOutput.writeInt(age);

    }

    public void readData(ObjectDataInput objectDataInput) throws IOException {
        name = objectDataInput.readUTF();
        address = objectDataInput.readUTF();
        age = objectDataInput.readInt();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

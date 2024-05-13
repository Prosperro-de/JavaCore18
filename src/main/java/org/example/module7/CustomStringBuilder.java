package org.example.module7;

public class CustomStringBuilder {
    byte[] array = new byte[10000];
    int pointer;

    public CustomStringBuilder append(String s){
       return null;
    }

    public String toString() {
        return new String(array);
    }

}

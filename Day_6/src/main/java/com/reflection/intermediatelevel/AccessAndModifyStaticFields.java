package com.reflection.intermediatelevel;

import java.lang.reflect.Field;

class Configuration{
    private static int API_KEY = 123123;
}
public class AccessAndModifyStaticFields {
    public static void main(String[] args) throws Exception{
        Configuration configuration = new Configuration();
        Class<?> cls = configuration.getClass();

        Field field = cls.getDeclaredField("API_KEY");
        field.setAccessible(true);
        System.out.println("Old API_KEY: "+ field.get(configuration));

        field.set(configuration, 321321);
        System.out.println("New API_KEY: "+ field.get(configuration));
    }
}

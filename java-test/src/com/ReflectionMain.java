package com;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by lawrence on 2016/12/22.
 */
public class ReflectionMain {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException,
            NoSuchFieldException, NoSuchMethodException {
        // TODO Auto-generated method stub
        System.out.println("===============================================");
        Demo1();
        //Demo2.  ��֤���е��඼��Class���ʵ������
        Demo2();
        System.out.println("===============================================");

        //Demo3.  ͨ��Java������ƣ���Class ���������[��Ҳ���Ƿ�����ڵ���������]���޲ι���
        Demo3();
        System.out.println("===============================================");

        //Demo4:  ͨ��Java������Ƶõ�һ����Ĺ��캯������ʵ�ֹ������ʵ������
        Demo4();
        System.out.println("===============================================");

        //Demo5:  ͨ��Java������Ʋ�����Ա����, set �� get
        Demo5();
        System.out.println("===============================================");
        //Demo6: ͨ��Java������Ƶõ����һЩ���ԣ� �̳еĽӿڣ����࣬������Ϣ����Ա��Ϣ�����͵�
        Demo6();
        System.out.println("===============================================");

        //Demo7: ͨ��Java������Ƶ������з���
        Demo7();
        System.out.println("===============================================");

        //Demo8: ͨ��Java������ƻ���������
        Demo8();
        System.out.println("===============================================");
    }

    /**
     * Demo2: ��֤���е��඼��Class���ʵ������
     *
     * @throws ClassNotFoundException
     */
    public static void Demo2() throws ClassNotFoundException {
        //�����������Ͷ�δ֪��Class , ���ó�ֵΪnull, ������θ����Ǹ�ֵ��Person��
        Class<?> class1 = null;
        Class<?> class2 = null;

        //д��1, �����׳� ClassNotFoundException [�������д��]
        class1 = Class.forName("com.Person");
        System.out.println("Demo2:(д��1) ����: " + class1.getPackage().getName() + "��"
                + "��������: " + class1.getName());

        //д��2
        class2 = Person.class;
        System.out.println("Demo2:(д��2) ����: " + class2.getPackage().getName() + "��"
                + "��������: " + class2.getName());
    }

    /**
     * Demo3: ͨ��Java������ƣ���Class ���������[��Ҳ���Ƿ�����ڵ���������]
     *
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static void Demo3() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> class1 = null;
        class1 = Class.forName("com.Person");
        //�������ﲻ�ܴ�������������Ҫʵ�����������Person��һ��Ҫ���޲ι��캯������
        Person person = (Person) class1.newInstance();
        person.setAge(20);
        person.setName("LeeFeng");
        System.out.println("Demo3: " + person.getName() + " : " + person.getAge());
    }

    /**
     * Demo4: ͨ��Java������Ƶõ�һ����Ĺ��캯������ʵ�ִ�������ʵ������
     *
     * @throws ClassNotFoundException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws IllegalArgumentException
     */
    public static void Demo4() throws ClassNotFoundException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class<?> class1 = null;
        Person person1 = null;
        Person person2 = null;

        class1 = Class.forName("com.Person");
        //�õ�һϵ�й��캯������
        Constructor<?>[] constructors = class1.getConstructors();

        person1 = (Person) constructors[0].newInstance();
        person1.setAge(30);
        person1.setName("leeFeng");

        person2 = (Person) constructors[1].newInstance(20, "leeFeng");

        System.out.println("Demo4: " + person1.getName() + " : " + person1.getAge()
                        + "  ,   " + person2.getName() + " : " + person2.getAge()
        );

    }

    /**
     * Demo5: ͨ��Java������Ʋ�����Ա����, set �� get
     *
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws NoSuchFieldException
     * @throws SecurityException
     * @throws InstantiationException
     * @throws ClassNotFoundException
     */
    public static void Demo5() throws IllegalArgumentException, IllegalAccessException, SecurityException, NoSuchFieldException, InstantiationException, ClassNotFoundException {
        Class<?> class1 = null;
        class1 = Class.forName("com.Person");
        Object obj = class1.newInstance();

        Field personNameField = class1.getDeclaredField("name");
        personNameField.setAccessible(true);
        personNameField.set(obj, "�ֻ���ɭ");


        System.out.println("Demo5: �޸�����֮��õ����Ա�����ֵ��" + personNameField.get(obj));

    }


    /**
     * Demo6: ͨ��Java������Ƶõ����һЩ���ԣ� �̳еĽӿڣ����࣬������Ϣ����Ա��Ϣ�����͵�
     *
     * @throws ClassNotFoundException
     */
    public static void Demo6() throws ClassNotFoundException {
        Class<?> class1 = null;
        class1 = Class.forName("com.SuperMan");

        //ȡ�ø�������
        Class<?> superClass = class1.getSuperclass();
        System.out.println("Demo6:  SuperMan��ĸ�����: " + superClass.getName());

        System.out.println("===============================================");


        Field[] fields = class1.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            System.out.println("���еĳ�Ա: " + fields[i]);
        }
        System.out.println("===============================================");


        //ȡ���෽��
        Method[] methods = class1.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.println("Demo6,ȡ��SuperMan��ķ�����");
            System.out.println("��������" + methods[i].getName());
            System.out.println("�����������ͣ�" + methods[i].getReturnType());
            System.out.println("�����������η���" + Modifier.toString(methods[i].getModifiers()));
            System.out.println("��������д���� " + methods[i]);
            Class<?>[] parameterTypes = methods[i].getParameterTypes();
            for (int j=0;j<parameterTypes.length;j++){
                //ע�⣺����޲�����ʲô�������ӡ
                System.out.println("������������ " + parameterTypes[j].getName());
            }



        }

        System.out.println("===============================================");

        //ȡ����ʵ�ֵĽӿ�,��Ϊ�ӿ���Ҳ����Class,���Եõ��ӿ��еķ���Ҳ��һ���ķ����õ���
        Class<?> interfaces[] = class1.getInterfaces();
        for (int i = 0; i < interfaces.length; i++) {
            System.out.println("ʵ�ֵĽӿ�����: " + interfaces[i].getName());
        }

    }

    /**
     * Demo7: ͨ��Java������Ƶ����෽��
     *
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws SecurityException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InstantiationException
     */
    public static void Demo7() throws ClassNotFoundException, SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> class1 = null;
        class1 = Class.forName("com.SuperMan");

        System.out.println("Demo7: \n�����޲η���fly()��");
        Method method = class1.getMethod("fly");
        method.invoke(class1.newInstance());

        System.out.println("�����вη���walk(int m)��");
        method = class1.getMethod("walk", int.class);
        method.invoke(class1.newInstance(), 100);
    }

    /**
     * Demo8: ͨ��Java������Ƶõ����������Ϣ
     * <p/>
     * ��java�������������������[����������Ͻ�ȡ]
     * <p/>
     * 1��Bootstrap ClassLoader �˼���������c++��д��һ�㿪���к��ټ���
     * <p/>
     * 2��Extension ClassLoader ����������չ��ļ��أ�һ���Ӧ����jre\lib\extĿ¼�е���
     * <p/>
     * 3��AppClassLoader ����classpathָ�����࣬����õļ�������ͬʱҲ��java��Ĭ�ϵļ�������
     *
     * @throws ClassNotFoundException
     */
    public static void Demo8() throws ClassNotFoundException {
        Class<?> class1 = null;
        class1 = Class.forName("com.SuperMan");
        String nameString = class1.getClassLoader().getClass().getName();
        System.out.println("Demo8: �����������: " + nameString);
    }

    public static void Demo1() {
        Person person = new Person();
        System.out.println("Demo1: ����: " + person.getClass().getPackage().getName() + "��"
                + "��������: " + person.getClass().getName());
    }

}




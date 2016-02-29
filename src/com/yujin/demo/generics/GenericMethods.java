package com.yujin.demo.generics;
/**
 * ���ǿ����ķ��ͣ�����Ӧ�����������ϣ���ͬ�����������а���������������
 * ������������ڵ�������Ƿ����࣬Ҳ���Բ��Ƿ��� �ࡣҲ����˵���Ƿ�ӵ�з��ͷ������������ڵ����Ƿ��Ƿ���û�й�ϵ��
 * 
 * @author yujin
 *
 */
public class GenericMethods {
    public <T> void f(T x) {
        System.out.println(x.getClass().getName());
    }
    
    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        gm.f("");
        gm.f(1);
        gm.f(1.0);
        gm.f(1.0f);
        gm.f('c');
        gm.f(gm);
        /**
         * ��ʵ�ϣ����ͷ������Զ���������������ǰ���ǲ��ò��Լ���д�����Ĵ��롣
         */
    }
}
/**
 * GenericMethods�����ǲ������ģ��������������ڲ��ķ������Ա�ͬʱ��������
 * ��������������У�ֻ�з���f()ӵ�����Ͳ����������ɸ÷����ķ�������ǰ������Ͳ����б�ָ���ġ�
 */

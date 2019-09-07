package com.socket;

/**
 * @author liulei
 * @Description lamada
 * @create 2017/7/28 20:33
 */
public class Lamada {
    public static void main(String[] args){
        Lamada lamada = new Lamada();

        MathOperation add = (int a,int b) ->  a + b;

    }
}

interface MathOperation{
    int operation(int a,int b);
}

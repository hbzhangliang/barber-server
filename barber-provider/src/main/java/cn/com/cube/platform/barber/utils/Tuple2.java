package cn.com.cube.platform.barber.utils;

import java.util.Optional;

public class Tuple2<A,B> {

    private A a;
    private B b;

    public Tuple2() {
    }

    public Tuple2(A a, B b) {
        this.a = a;
        this.b = b;
    }

    public void  _1(A a){
        this.a=a;
//        return this;
    }

    public void _2(B b){
        this.b=b;
//        return this;
    }

    public Optional<A> _1() {
        return Optional.ofNullable(a);
    }

    public Optional<B> _2() {
        return Optional.ofNullable(b);
    }


    @Override
    public String toString() {
        return "Tuple2{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}

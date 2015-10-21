package com.yujin.demo.generics;

public class TupleTest {

	static TwoTuple<String, Integer> f() {
		return new TwoTuple<String, Integer>("hi", 25);
	}

	static ThreeTuple<Amphibian, String, Integer> g() {
		return new ThreeTuple<Amphibian, String, Integer>(new Amphibian(),
				"hi", 35);
	}

	static FourTuple<Vehicle, Amphibian, String, Integer> h() {
		return new FourTuple<Vehicle, Amphibian, String, Integer>(
				new Vehicle(), new Amphibian(), "hi", 25);
	}

	static FiveTuple<Vehicle, Amphibian, String, Integer, Double> k() {
		return new FiveTuple<Vehicle, Amphibian, String, Integer, Double>(
				new Vehicle(), new Amphibian(), "hi", 26, 12.6);
	}

	public static void main(String[] args) {

	}
}

class Amphibian {}

class Vehicle {}
package gp.utils;

import java.util.Random;

public class Noise {
	
	private final static int NOISE_LENGTH = 256;
	private int[] perm;
	private float[] noiseTable;
	
	private final Random random = new Random();
	
	public Noise() {
		initPerm();
		initNoiseTable();
	}

	private void initNoiseTable() {
		noiseTable = new float[NOISE_LENGTH];
		for( int i = 0; i < NOISE_LENGTH; i++ ) {
			noiseTable[i] = random.nextFloat()/32767.99f;
		}
	}
	
	public float latticeNoise(int i, int j, int k) {
		return noiseTable[hash(i,j,k)];
	}

	private int hash(int i,int j,int k) {
		return perm[(i + perm[(j + perm[k%NOISE_LENGTH])%256])%256];
	}
	
	private void initPerm() {
		
		perm = new int[NOISE_LENGTH];
		
		for( int i = 0; i < NOISE_LENGTH; i++ ) {
			perm[i] = i;
		}
		
		for( int i = 0; i < NOISE_LENGTH; i++ ) {
			int k = random.nextInt(NOISE_LENGTH);
			swap(perm, k, i);
		}
		
	}
	
	private static void swap(int[] array, int from, int to) {
		final int temp = array[to];
		array[to] = array[from];
		array[from] = temp;
	}
	
}

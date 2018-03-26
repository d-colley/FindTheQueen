package com.FindTheQueen;

public class ClientCounter {
	int readyCount = 0;
	
	public int getCount()
	{
		return readyCount;
	}
	
	public void IncrementCount (int num)
	{
		readyCount = readyCount + num;
	}
	
	public void Empty ()
	{
		readyCount = 0;
	}
	
}

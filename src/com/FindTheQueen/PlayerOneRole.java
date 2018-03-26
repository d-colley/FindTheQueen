package com.FindTheQueen;

public class PlayerOneRole {
int roleBool = 0; // 0 for spotter, 1 for dealer
	
	public int GetRole()
	{
		return roleBool;
	}
	
//	public int RoleShuffle()
//	{
//		
//	}
	
	public void SetDealer()
	{
		roleBool = 1;
	}
	
	public void SetSpotter()
	{
		roleBool = 0;
	}
	
	
//	public void IncrementCount (int num)
//	{
//		readyCount = readyCount + num;
//	}
	
	public void Empty ()
	{
		roleBool = 0;
	}
}

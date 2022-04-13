package com.crm.TESTCASES;

import org.testng.annotations.Test;

import com.Generic.ExcelUtil;

public class PracticeExcelTest
{

	@Test
	
	public void practiceexcel() throws Throwable
	{
		
		ExcelUtil excelutil= new ExcelUtil();
		int lastrow=excelutil.getRowCount( Iautoconstatants.excelpath, "Sheet1");

		for (int i=0;i<=lastrow;i++) 
		   {
			
			int sal=excelutil.readNumericdatafromExcel(Iautoconstatants.excelpath, "Sheet1", i, 1);
			
			if(sal>=30000)
			{
		String name=excelutil.readStringdatafromExcel(Iautoconstatants.excelpath, "Sheet1", i, 0);
		System.out.println(name);
			}
		}
	}
	
}

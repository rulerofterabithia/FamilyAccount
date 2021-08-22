package com.cyk.familyaccount;

public class FamilyAccount {
	public static void main(String[] args) {
		boolean isFlag = true;
		// 用于记录用户收入和支出的详情
		String details = "收支		收支金额		账户余额		说   明\n";
		// 初始金额
		int balance = 10000;
		while (isFlag) {
			System.out.println("--------------------家庭收支记账软件---------------------\n");
			System.out.println("                      1、收支明细");
			System.out.println("                      2、登记收入");
			System.out.println("                      3、登记支出");
			System.out.println("                      4、退   出\n");
			System.out.println("--------------------------------------------------------\n");
			System.out.print("       请选择(1~4):");
			// 获取用户的选择:1~4
			char selection = Utility.readMenuSelection();
			switch (selection) {
			case '1':
				System.out.println("--------------------当前收支明细记录---------------------\n");
				System.out.println(details);
				System.out.println("--------------------------------------------------------\n");
				break;
			case '2':
				System.out.print("本次收入金额:");
				int money = Utility.readNumber();
				System.out.print("本次收入说明:");
				String addInfo = Utility.readString();
				// 处理balance
				balance += money;
				// 处理details
				details += ("收入		 " + money + "		  " + balance + "		 " + addInfo + "\n");
				System.out.println("-----------------------登记完成!-------------------------\n");
				break;
			case '3':
				System.out.print("本次支出金额:");
				int pay = Utility.readNumber();
				// 处理balance
				if (balance > pay) {
					balance -= pay;
					System.out.print("本次支出说明:");
					String payInfo = Utility.readString();
					// 处理details
					details += ("支出		 " + pay + "		  " + balance + "		 " + payInfo + "\n");
					System.out.println("-----------------------登记完成!-------------------------\n");
				} else {
					System.out.println("您的账户余额不足!请重新登记!");
				}	
				break;
			case '4':
				System.out.print("是否确认退出?(请输入Y或N):");
				char isExit = Utility.readConfirmSelection();
				if (isExit == 'Y') {
					isFlag = false;
				}
				// break;
			}
		}
	}
}

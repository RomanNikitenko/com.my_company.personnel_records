package employee;

import java.math.BigDecimal;

import util.MyUtil;

public abstract class Employee {
	
	protected int 	 personalNumber;			//��������� ����� ����������
	protected String surnameNameMiddlename,     //�������, ���, �������� ����������
//					 name,						//��� 
//					 middleName,  				//��������
					 education,					//�����������
//					 profession,				//�������������
					 post, 						// ���������
					 department,  				// �����

				     offPassport,   			//��� ����� �������
				     cityPassport,  			//����� ������ ��������
				     numPassport,   			//����� ��������
				     datePassport,  			//���� ������
				     
					 cityResidence,				//�����
					 street;        			//�����
	protected int    zip;           			// �������� ������
	protected short  numHouse,      			//����� ����
	   				 numApprtment;  			//����� ��������
	
	protected long taxIdentifNum;   			//������� ����� �����������������
	protected BigDecimal 
					averageSalary; 				//��������
	
	//������/�������
	
	//��������: ������� �� �����������, ������� - ������ �����

	public static void main(String[] args) throws Exception {
	String [][] mass = MyUtil.readDataEmployeeFromFile("C:\\PersonnelRecordsTest\\TestListEmployee.out");
	int a = 0;
	}//main

}//class

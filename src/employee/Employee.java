package employee;

import java.math.BigDecimal;
import java.util.ArrayList;

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


}//class

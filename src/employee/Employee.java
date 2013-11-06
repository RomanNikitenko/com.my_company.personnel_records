package employee;

import java.math.BigDecimal;
import java.util.ArrayList;

import util.MyUtil;

public abstract class Employee {
	
	protected int 	 personalNumber;			//табельный номер сотрудника
	protected String surnameNameMiddlename,     //фамилия, имя, отчество сотрудника
//					 name,						//имя 
//					 middleName,  				//Отчество
					 education,					//образование
//					 profession,				//специальность
					 post, 						// должность
					 department,  				// отдел

				     offPassport,   			//кем выдан паспорт
				     cityPassport,  			//город выдачи паспорта
				     numPassport,   			//номер паспорта
				     datePassport,  			//дата выдачи
				     
					 cityResidence,				//город
					 street;        			//Улица
	protected int    zip;           			// почтовый индекс
	protected short  numHouse,      			//номер дома
	   				 numApprtment;  			//номер квартиры
	
	protected long taxIdentifNum;   			//идентиф номер налогоплатильщика
	protected BigDecimal 
					averageSalary; 				//зарплата
	
	//гетеры/сеттеры
	
	//проверка: возраст не отрицателен, фамилия - только буквы


}//class

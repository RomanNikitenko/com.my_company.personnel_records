package com.company.personnelrecords.testmode;

import com.company.personnelrecords.util.MyUtil;

public class TestMode {

	
	private static String [] arrEducation = {"Средне-специальное", "Высшее", "Незаконченное высшее",
											"Среднее"};
	private static String [] arrPost = 	  {"Управляющий", "Инженер", "Слесарь", "Менеджер",
									"Технический директор", "Офис-менеджер", "Сисадмин",
									"Обслуживающий персонал"};
	private static String [] arrDepartment = {"Отдел работы с клиентами", "Технический отдел", "Хоз-часть", "Аналитический отдел",
									"Отдел сборки"};
	private static String [] arrOffPassport = {"Сосновским РВ УМВС", "Приднепровским РВ УМВС"};
	private static String [] arrCity = {"г. Черкассы", "г. Киев", "г. Харьков", "г. Смела"};
	private static String [] arrStreet = {"ул. Шевченка", "ул. Гоголя", "ул. Сумгаитская", "ул. Ленина"};
	
	
//**************************************************************
	/**Метод, генерирует   random-данные по полям EmployeeFixedSalary и EmployeeHourlyWages 
	 * и записывает их в файл.
	 * Для генерации случайных данных использовано два источника:
	 * -  массивы класса Test
	 * -  файл с данными.
	 * @param amountEmployee int - количество генерируемых сотрудников
	 * @param pathFileOut String - путь к файлу, в который будет произведена запись сгенерированных данных
	 * @return String [] - массив сгенерированных данных 
	 * @throws Exception
	 */
	public static String[] generationEmployeeDataAndFiling (int amountEmployee, 
															String pathFileOut)	throws Exception {
		
		//Генерируем последовательность фамилий, имен и отчеств
		String [] arrSurnameNameMiddlename = generationRandomSurnameNameMiddlename(amountEmployee);
		
		// генерируем массив random-data Education
		String [] arrRandomDataEducation = MyUtil.generationRandomCellsOfArray(arrEducation, amountEmployee);
		
		// генерируем массив random-data Post
		String [] arrRandomDataPost = MyUtil.generationRandomCellsOfArray(arrPost, amountEmployee);
		
		// генерируем массив random-data Department
		String [] arrRandomDataDepartment = MyUtil.generationRandomCellsOfArray(arrDepartment, amountEmployee);

		// генерируем массив random-data OffPassport
		String [] arrRandomDataOffPassport = MyUtil.generationRandomCellsOfArray(arrOffPassport, amountEmployee);

		// генерируем массив random-data CityPassport
		String [] arrRandomDataCityPassport = MyUtil.generationRandomCellsOfArray(arrCity, amountEmployee);

		// генерируем массив random-data CityResidence
		String [] arrRandomDataCityResidence = MyUtil.generationRandomCellsOfArray(arrCity, amountEmployee);
		
		// генерируем массив random-data street
		String [] arrRandomDataStreet = MyUtil.generationRandomCellsOfArray(arrStreet, amountEmployee);
		
		// генерируем массив random-data numPassport
		String [] arrRandomDataNumPassport = MyUtil.generateRandomNumPass(amountEmployee);
		
		// генерируем массив random-data дату выдачи паспорта
		String [] arrRandomDataDatePassport = MyUtil.generateRandomDatePassport(amountEmployee);
		
		// генерируем массив random-data почтового индекса
		int [] arrRandomDataZip = MyUtil.createArrRandomNum(amountEmployee, 10000, 19000);
		
		// генерируем массив random-data номер дома
		int [] arrRandomDataNumHouse = MyUtil.createArrRandomNum(amountEmployee, 1, 500);
		
		// генерируем массив random-data номер квартиры
		int [] arrRandomDataNumApprtment = MyUtil.createArrRandomNum(amountEmployee, 1, 300);
		
		// генерируем массив random-data индетифик. номер
		long [] arrRandomDataTaxIdentifNum = MyUtil.createArrRandomNum(amountEmployee, 1000000000l, 9999999999l);

		// генерируем массив random-data средняя зарплата
		int [] arrRandomDataAverageSalary = MyUtil.createArrRandomNum(amountEmployee, 2000, 10000);

		// генерируем массив random-data табельный номер сотрудника
		int [] arrRandomDataPersonalNum = MyUtil.createArrRandomNum(amountEmployee, 1, 10000);
		
		/*В моей упрощенной модели список полей классов EmployeeHourlyWages и EmployeeFixedSalary
		*отличается только полями hourlyRate и monthlyPayment. Соответственно данный метод сможет генерировать данные
		* по обеим классам сотрудников. Для этого делаем проверку: 
		* - если название файла, в который будет произведена запись содержит "EmployeesFixedSalary",
		* то генерируем поле "monthlyPayment" и записываем random-data в файл
		* - если название файла, в который будет произведена запись содержит "EmployeesHourlyWages",
		* то генерируем поле "hourlyRate" и записываем random-data в файл
		*/ 
		String [] arrEmployeeData = new String [arrSurnameNameMiddlename.length];
		
		if (pathFileOut.indexOf("EmployeesFixedSalary") != (-1)) {
			int [] arrRandomDataMonthlyPayment = MyUtil.createArrRandomNum(amountEmployee, 2000, 10000);
			
			/* Подготовка для записи в файл - соединяем записи в массив строк,
			 * при этом перед актуальной инфо ставим ключевое слово
			 */
			for (int i = 0; i < arrEmployeeData.length; i++) {
				arrEmployeeData[i] = "Personal Number: " + arrRandomDataPersonalNum[i] +  "   surname/Name/Middlename: " +  arrSurnameNameMiddlename[i] +
						 "   department: " +  arrRandomDataDepartment[i] +  "   post: " + arrRandomDataPost[i] +  "   averageSalary: " +  arrRandomDataAverageSalary[i] +
						 "   monthlyPayment: " + arrRandomDataMonthlyPayment[i] + "   taxIdentifNum: " + arrRandomDataTaxIdentifNum[i] + 
						 "   Education: " + arrRandomDataEducation[i] + "   Passport: " + arrRandomDataNumPassport[i] + ", выдан " + arrRandomDataDatePassport[i] + ", " +
						 arrRandomDataOffPassport[i] + " " + arrRandomDataCityPassport[i] + "   Residance: " + arrRandomDataZip[i] + ", " + arrRandomDataCityResidence[i] +
						 ", " + arrRandomDataStreet[i] + " " + arrRandomDataNumHouse[i] + ", кв. " + arrRandomDataNumApprtment[i];
			}//for
		}//
		else if (pathFileOut.indexOf("EmployeesHourlyWages") != (-1)) {
			int [] arrRandomDataHourlyRate = MyUtil.createArrRandomNum(amountEmployee, 13, 63);
		
			for (int i = 0; i < arrEmployeeData.length; i++) {
				arrEmployeeData[i] = "Personal Number: " + arrRandomDataPersonalNum[i] +  "   surname/Name/Middlename: " +  arrSurnameNameMiddlename[i] +
						 "   department: " +  arrRandomDataDepartment[i] +  "   post: " + arrRandomDataPost[i] +  "   averageSalary: " +  arrRandomDataAverageSalary[i] +
						 "   hourlyRate: " + arrRandomDataHourlyRate [i] + "   taxIdentifNum: " + arrRandomDataTaxIdentifNum[i] + 
						 "   Education: " + arrRandomDataEducation[i] + "   Passport: " + arrRandomDataNumPassport[i] + ", выдан " + arrRandomDataDatePassport[i] + ", " +
						 arrRandomDataOffPassport[i] + " " + arrRandomDataCityPassport[i] + "   Residance: " + arrRandomDataZip[i] + ", " + arrRandomDataCityResidence[i] +
						 ", " + arrRandomDataStreet[i] + " " + arrRandomDataNumHouse[i] + ", кв. " + arrRandomDataNumApprtment[i];
			}//for

		}//
		//Записываем сформированный массив результата в файл
		MyUtil.recMassStr(pathFileOut, arrEmployeeData);
		
		return arrEmployeeData;
	}//generationEmployeeDataAndFiling

//**************************************************************
		/**Метод: 1. Считывает из файла "InputForTest.in" (лежит в корне проекта) корни фамилий, окончания фамилий,
		 * имена и отчества; 2. Генерирует  случайным образом ПОСЛЕДОВАТЕЛЬНОСТЬ фамилий, имен и отчеств.
		 * Выбирается случайным образом корень фамилии(генерируется его номер методом некстИнт()),
		 * потом аналогично выбирается окончание некстИнт() и объединяются в фамилию.
		 * Имена считываются из файла, генерируется случайный номер имени.
		 * Отчество - аналогично имени.
		 * Грамматичекая правильность последовательности не важна.
		 * 
		 * @param amountGeneration int - количество необходимых генераций
		 * @return String [] - массив сгенерированных фамилий, имен и отчеств 
		 * @throws Exception
		 */
	public static String [] generationRandomSurnameNameMiddlename (int amountGeneration) throws Exception {
		
		//Считываем файл, который содержит корни фамилий, окончания фамилий, имена и отчества
		String [] arrStrFromFile = MyUtil.readFile("src/main/resources/InputForTest.in");
		
		String [] arrRootsSurnames = null;
		String [] arrSurnameCompletions = null;
		String [] arrNames = null;
		String [] arrMiddlenames = null;
		
		for (int i = 0; i < arrStrFromFile.length; i++) {
			String buf = arrStrFromFile[i];
			int indexKeyword1 = buf.indexOf("RootsOfSurnames:");
			int indexKeyword2 = buf.indexOf("CompletionsOfSurnames:");
			int indexKeyword3 = buf.indexOf("Names:");
			int indexKeyword4 = buf.indexOf("Middlenames:");
			if (indexKeyword1 != -1) {
				//считываем из файла КОРНИ фамилий в массив строк
				arrRootsSurnames = MyUtil.returnArrTokenAfterKeyWord(buf, "RootsOfSurnames:");
			}//if
			else if (indexKeyword2 != -1) {
				//считываем из файла ОКОНЧАНИЯ фамилий в массив строк
				arrSurnameCompletions = MyUtil.returnArrTokenAfterKeyWord(buf, "CompletionsOfSurnames:");
			}//if
			else if (indexKeyword3 != -1) {
				//считываем из файла ИМЕНА в массив строк
				arrNames = MyUtil.returnArrTokenAfterKeyWord(buf, "Names:");
			}//if
			else if (indexKeyword4 != -1) {
				//считываем из файла ОТЧЕСТВА в массив строк
				arrMiddlenames = MyUtil.returnArrTokenAfterKeyWord(buf, "Middlenames:");
			}//if
		}//for
		
		//генерируем массив номеров КОРНЯ фамилий
		int [] rootsNum = MyUtil.createArrRandomNum(amountGeneration, 0, arrRootsSurnames.length);
		
		//генерируем массив номеров ОКОНЧАНИЙ фамилий
		int [] numComplet = MyUtil.createArrRandomNum(amountGeneration, 0, arrSurnameCompletions.length);
		
		//склеиваем корень фамилии с окончанием и запоминаем в массив
		String [] arrRandomDataSurnames = MyUtil.glueCellsArrays(arrRootsSurnames, rootsNum, arrSurnameCompletions, numComplet);
		
		// генерируем массив random-data ИМЕН
		String [] arrRandomDataNames = MyUtil.generationRandomCellsOfArray(arrNames, amountGeneration);

		// генерируем массив random-data ОТЧЕСТВ
		String [] arrRandomDataMiddlenames = MyUtil.generationRandomCellsOfArray(arrMiddlenames, amountGeneration);

		//Склеиваем массив фамилий с массивом имен и массивом отчеств в один массив
		String[] arrResult = MyUtil.glueCellsArrays(arrRandomDataSurnames, arrRandomDataNames, arrRandomDataMiddlenames, " ");

		return arrResult;
	}//generationRandomSurnameNameMiddlename ()
//**************************************************************
	public static void main(String[] args) throws Exception {
//***********************************************************		
	}//main

}//class

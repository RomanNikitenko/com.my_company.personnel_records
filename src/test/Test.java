package test;

import util.MyUtil;

public class Test {

	
	private static String [] arrEducation = {"Высшее", "Незаконченное высшее",
									"Среднее", "Средне-специальное"};
	private static String [] arrPost = 	  {"Управляющий", "Инженер", "Слесарь", "Менеджер",
									"Технический директор", "Офис-менеджер", "Сисадмин",
									"Обслуживающий персонал"};
	private static String [] arrDepartment = {"Отдел работы с клиентами", "Технический отдел", "Хоз-часть", "Аналитический отдел",
									"Отдел сборки"};
	private static String [] arrOffPassport = {"Сосновским РВ УМВС", "Приднепровским РВ УМВС"};
	private static String [] arrCity = {"г. Черкассы", "г. Киев", "г. Харьков", "г. Смела"};
	private static String [] arrStreet = {"ул. Шевченка", "ул. Гоголя", "ул. Сумгаитская", "ул. Ленина"};
	
	
//**************************************************************
	/**Метод, генерирует   random-данные по сотрудникам и записывает их в файл.
	 * Для генерации случайных данных использовано два источника:
	 * -  массивы класса Test
	 * -  файлы с данными.
	 * @param amountEmployee int - количество генерируемых сотрудников
	 * @param pathFileWithRoots String - путь к файлу с корнями фамилий
	 * @param pathFileWithCompletions String - путь к файлу с окончаниями фамилий
	 * @param pathFileWithNames String - путь к файлу с именами
	 * @param pathFileWithMiddlenames String - путь к файлу с отчествами
	 * @param pathFileOut String - путь к файлу, в который будет записана
	 *  сгенерированная последовательность фамилий, имен и отчеств
	 * @return String [] - массив сгенерированных фамилий, имен и отчеств 
	 * @throws Exception
	 */
	public static String[] generationEmployeeDataAndFiling (int amountEmployee, String pathFileWithRoots,
			String pathFileWithCompletions, String pathFileWithNames, String pathFileWithMiddlenames,
			String pathFileOut)	throws Exception {
		
		//Генерируем последовательность фамилий, имен и отчеств
		String [] arrSurnameNameMiddlename = generationRandomSurnameNameMiddlename(amountEmployee, pathFileWithRoots,
											pathFileWithCompletions, pathFileWithNames,pathFileWithMiddlenames);
		
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
		
		/* Подготовка для записи в файл - соединяем записи в массив строк,
		 * при этом перед актуальной инфо ставим ключевое слово
		 */
		String [] arrEmployeeData = new String [arrSurnameNameMiddlename.length];
		
		for (int i = 0; i < arrEmployeeData.length; i++) {
			arrEmployeeData[i] = "Personal Number: " + arrRandomDataPersonalNum[i] +  "   surname/Name/Middlename: " +  arrSurnameNameMiddlename[i] +
					 "   department: " +  arrRandomDataDepartment[i] +  "   post: " + arrRandomDataPost[i] +  "   averageSalary: " +  arrRandomDataAverageSalary[i] +
					 "   taxIdentifNum: " + arrRandomDataTaxIdentifNum[i] + "   Education: " + arrRandomDataEducation[i] + "   Passport: " + arrRandomDataNumPassport[i] +
					 ", выдан " + arrRandomDataDatePassport[i] + ", " + arrRandomDataOffPassport[i] + " " + arrRandomDataCityPassport[i] + "   Residance: " + 
					 arrRandomDataZip[i] + ", " + arrRandomDataCityResidence[i] + ", " + arrRandomDataStreet[i] + " " + arrRandomDataNumHouse[i] + ", кв. " + 
					 arrRandomDataNumApprtment[i];
		}//for
		
		//Записываем сформированный массив результата в файл
		MyUtil.recMassStr(pathFileOut, arrEmployeeData);
		
		return arrEmployeeData;
	}//generationEmployeeDataAndFiling

//**************************************************************
		/**Метод, генерирует  случайным образом ПОСЛЕДОВАТЕЛЬНОСТЬ фамилий, имен и отчеств.
		 * Выбирается случайным образом корень фамилии(генерируется его номер методом некстИнт()),
		 * потом аналогично выбирается окончание некстИнт() и объединяются в фамилию.
		 * Имена считываются из файла, генерируется случайный номер имени.
		 * Отчество - аналогично имени.
		 * Грамматичекая правильность последовательности не важна.
		 * @param pathFileWithRoots String - путь к файлу с корнями фамилий
		 * @param pathFileWithCompletions String - путь к файлу с окончаниями фамилий
		 * @param pathFileWithNames String - путь к файлу с именами
		 * @param pathFileWithMiddlenames String - путь к файлу с отчествами
		 * @return String [] - массив сгенерированных фамилий, имен и отчеств 
		 * @throws Exception
		 */
	public static String[] generationRandomSurnameNameMiddlename(int amountGeneration, String pathFileWithRoots,
			String pathFileWithCompletions, String pathFileWithNames, String pathFileWithMiddlenames)
			throws Exception {

		// Генерируем фамилии в массив строк (случайно корень + случайно окончание)
		String[] arrRandomDataSurnames = generationRandomSurnames (amountGeneration, pathFileWithRoots, pathFileWithCompletions);

		// считываем из файла ИМЕНА в массив строк
		String[] arrNames = MyUtil.readFile(pathFileWithNames);
		
		// считываем из файла ОТЧЕСТВА в массив строк
		String[] arrMiddlenames = MyUtil.readFile(pathFileWithMiddlenames);

		// генерируем массив random-data ИМЕН
		String [] arrRandomDataNames = MyUtil.generationRandomCellsOfArray(arrNames, amountGeneration);

		// генерируем массив random-data ОТЧЕСТВ
		String [] arrRandomDataMiddlenames = MyUtil.generationRandomCellsOfArray(arrMiddlenames, amountGeneration);

		//Склеиваем массив фамилий с массивом имен и массивом отчеств в один массив
		String[] arrResult = MyUtil.glueCellsArrays(arrRandomDataSurnames, arrRandomDataNames, arrRandomDataMiddlenames, " ");
		
		return arrResult;
	}// generationRandomSurnameNameMiddlename ()

//**************************************************************
	/**Метод, генерирует  случайным образом ПОСЛЕДОВАТЕЛЬНОСТЬ фамилий от корней с помощью окончаний.
	 * Выбирается случайным образом корень (генерируется его номер методом некстИнт()),
	 * потом аналогично выбирается окончание некстИнт() и объединяются в фамилию.
	 * Грамматичекая правильность фамилии не важна.
	 * @param pathFileWithRoots String - путь к файлу с корнями фамилий
	 * @param pathFileWithCompletions String - путь к файлу с окончаниями фамилий
	 * @return String [] - массив сгенерированных фамилий 
	 * @throws Exception
	 */
	public static String [] generationRandomSurnames (int amountGeneration, String pathFileWithRoots, 
													  String pathFileWithCompletions) throws Exception {
		
		//считываем из файла КОРНИ фамилий в массив строк
		String [] arrRootsSurnames = MyUtil.readFile(pathFileWithRoots);
		
		//считываем из файла ОКОНЧАНИЯ фамилий в массив строк
		String [] arrNameCompletions = MyUtil.readFile(pathFileWithCompletions);
		
		//генерируем массив номеров КОРНЯ фамилий
		int [] rootsNum = MyUtil.createArrRandomNum(amountGeneration, 0, arrRootsSurnames.length);
		
		//генерируем массив номеров ОКОНЧАНИЙ фамилий
		int [] numComplet = MyUtil.createArrRandomNum(amountGeneration, 0, arrNameCompletions.length);
		
		//склеиваем корень фамилии с окончанием и запоминаем в массив
		String [] arrSurnames = MyUtil.glueCellsArrays(arrRootsSurnames, rootsNum, arrNameCompletions, numComplet);
		
		return arrSurnames;
	}//generationRandomSurnames ()
//**************************************************************
	public static void main(String[] args) throws Exception {
//***********************************************************		
		generationEmployeeDataAndFiling(50, "C:\\PersonnelRecordsTest\\RootsOfSurnames.in", "C:\\PersonnelRecordsTest\\CompletionsOfnames.in",
				"C:\\PersonnelRecordsTest\\Names.in", "C:\\PersonnelRecordsTest\\Middlename.in", "TestListEmployee.out");
	}//main

}//class

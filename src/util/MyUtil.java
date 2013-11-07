package util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;



public class MyUtil {
//***************************************************************************	
	/**
	 * Метод читает данные по сотрудникам из файла и заносит в ArrayList<ArrayList<String>>. Работа метода
	 * основана на считывании инфо, которая идет после ключевого слова
	 * @param pathFileIn
	 *            String - путь к файлу
	 * @return ArrayList<ArrayList<String>> - считанные данные
	 * @throws Exception
	 */
	public static ArrayList<ArrayList<String>> readDataEmployeeFromFile(String pathFileIn) throws Exception {

		RandomAccessFile raf = new RandomAccessFile(pathFileIn, "r");
		/*
		 * Метод возвращает массив позиций непустых строк в файле, //выраженный
		 * в байтах
		 */
		int[] massPosNoneEmptyStr = countStrInFile(pathFileIn);
		ArrayList<ArrayList<String>> arrListDataEmployees = new ArrayList<ArrayList<String>>(); 

		// *******//читаем построчно файл, делаем анализ инфо и заполняем массив данных
		while (raf.getFilePointer() < raf.length()) {

			for (int j = 0; j < massPosNoneEmptyStr.length; j++) {

				raf.seek(massPosNoneEmptyStr[j]);// устанавливаем каретку в позицию непустой строки

				/*
				 * запоминаем строку для дальнейшего анализа, при этом - делаем
				 * перекодировку - избавляемся от различного рода пробелов
				 * вначале и конце строки
				 */
				String buf = new String(raf.readLine().getBytes("ISO-8859-1"), "Cp1251".trim());
				ArrayList<String> row = new ArrayList<String>();
					row.add(returnStrBetweenKeyWords(buf, "Personal Number:", 			"surname/Name/Middlename:"));
					row.add(returnStrBetweenKeyWords(buf, "surname/Name/Middlename:", 	"department:"));
					row.add(returnStrBetweenKeyWords(buf, "department:", 				"post:"));
					row.add(returnStrBetweenKeyWords(buf, "post:", 						"averageSalary:"));
					row.add(returnStrBetweenKeyWords(buf, "taxIdentifNum:", 			"Education:"));
					row.add(returnStrBetweenKeyWords(buf, "Education:", 				"Passport:"));
					row.add(returnStrBetweenKeyWords(buf, "Passport:", 					"Residance:"));
					row.add(returnStrAfterKeyWord   (buf, "Residance:"));

					/*В моей упрощенной модели список полей классов EmployeeHourlyWages и EmployeeFixedSalary
					*отличается только полями hourlyRate и monthlyPayment. Соответственно данный метод сможет читать данные
					* по обеим классам сотрудников. Для этого проверяем какое ключевое слово (monthlyPayment или hourlyRate)
					* присутствует в файле для чтения и считываем нужное поле
					*/
					int indexKeyword1 = buf.indexOf("monthlyPayment");
					int indexKeyword2 = buf.indexOf("hourlyRate");
					
					if (indexKeyword1 != (-1)) {
						row.add(4, returnStrBetweenKeyWords(buf, "averageSalary:", 			"monthlyPayment:"));
						row.add(5, returnStrBetweenKeyWords(buf, "monthlyPayment:", 			"taxIdentifNum:"));
					}//
					else if (indexKeyword2 != (-1)) {
						row.add(4, returnStrBetweenKeyWords(buf, "averageSalary:", 			"hourlyRate:"));
						row.add(5, returnStrBetweenKeyWords(buf, "hourlyRate:", 			"taxIdentifNum:"));
					}//
					arrListDataEmployees.add(row);
			}// for
		}// while
		raf.close();
		return arrListDataEmployees;
	}// readDataEmployeeFromFile()
//*****************************************************************************************************
	/**
	 * Метод считывает инфо между ключевыми словами
	 * 
	 * @param strForAnalysis
	 *            String - строка для анализа
	 * @param keyWord1
	 *            String - первое ключевое слово
	 * @param keyWord2
	 *            String - второе ключевое слово

	 * @return String - подстрока, которая заключена между ключевых слов
	 */
	public static String returnStrBetweenKeyWords(String strForAnalysis,
			String keyWord1, String keyWord2) {

		int indexKeyWord1 = strForAnalysis.indexOf(keyWord1);
		int indexKeyWord2 = strForAnalysis.indexOf(keyWord2);
		String result = strForAnalysis.substring(indexKeyWord1 + keyWord1.length(), indexKeyWord2).trim();
		return result;
	}// returnStrBetweenKeyWords
//*****************************************************************************************************
		/**
		 * Метод считывает инфо, которая стоит после ключевого слова до конца строки
		 * 
		 * @param strForAnalysis
		 *            String - строка для анализа
		 * @param keyWord1
		 *            String - первое ключевое слово
		 * @param keyWord2
		 *            String - второе ключевое слово
		 * @return String - подстрока, которая заключена между ключевых слов
		 */
		public static String returnStrAfterKeyWord(String strForAnalysis, String keyWord) {

			int indexKeyWord = strForAnalysis.indexOf(keyWord);
			String result = strForAnalysis.substring(indexKeyWord + keyWord.length()).trim();
			return result;
		}// returnStrAfterKeyWord

// ******************************************************
		/**
		 * Метод разбивает подстроку, которая стоит после ключевого слова, на токены
		 * и возвращает их в виде массива
		 * @param strForAnalysis String - строка для анализа
		 * @param keyWord String - ключевое слово
		 * @return String[] - массив токенов, полученных из подстроки, которая стоит после ключевого слова.
		 */
		public static String [] returnArrTokenAfterKeyWord (String strForAnalysis, String keyWord) {
			
			ArrayList<String> arrListTokens = new ArrayList<String>();
			int indexKeyWord = strForAnalysis.indexOf(keyWord);
			String subStr = strForAnalysis.substring(indexKeyWord+keyWord.length()).trim();
			
			StringTokenizer strToken = new StringTokenizer(subStr, " :,\t\n\r\f");
			while (strToken.hasMoreTokens()) {
				arrListTokens.add(strToken.nextToken());
			}//while
			
		return arrListTokens.toArray(new String [arrListTokens.size()]);
		}//returnStrAfterKeyWord()
	
//*******************************************************
		/**
		 * Метод поллучает на вход массив String [] и количество генераций.
		 * Возвращает массив  arrResult.length = amountGeneration,
		 *  каждая ячейка которого = random-ячейка массива, полученного в параметре 
		 * 
		 * @param arr
		 *            String [] - исходный массив для генерации random-данных
		 * @param amountGeneration
		 *            int - количество необходимых генераций random-ячеек = arrResult.length массива результата
		 * @return String [] - массив массива результата
		 */
		public static String[] generationRandomCellsOfArray(String[] arr, int amountGeneration) {
			//генерируем массив random-номеров массива, полученного в параметре
			int[] arrRandomNumCells = createArrRandomNum(amountGeneration, 0, arr.length);
			
			String[] arrResult = new String[amountGeneration];
			for (int i = 0; i < arrResult.length; i++) {
				arrResult[i] = arr[arrRandomNumCells[i]];
			}// for
			return arrResult;
		}// generationRandomCellsOfArray ()

//******************************************************************************************
	/** Метод генерирует заданное в параметре количество случайных чисел в заданом диапазоне
	 * @param quantityNum int - количество генераций случайных чисел
	 * @param num1 long - нижняя граница диапазона
	 * @param num2 long - верхняя граница диапазона
	 * @return long [] - массив случайных чисел в заданном диапазоне
	 */
	public static long [] createArrRandomNum (int quantityNum, long num1, long num2) {
	
		Random rndm = new Random();
		long [] arrRandomNum = new long [quantityNum];
		
		if (num2 > num1) {
			for (int i = 0; i < quantityNum; i++) {
				arrRandomNum [i] = num1 + rndm.nextInt((int) (num2-num1));
			}//for
		}//if
		else System.out.println("ВВеден некорректный диапазон значений: Параметр2 меньше параметра1");
		
		return arrRandomNum;
	}//ArrRandomNum
// ***********************************************************************************************************************************

	/**
	 * Метод записывает массив строк в файл, путь к которому получен в параметре
	 * и проверяет, произведена ли запись в файл
	 * 
	 * @param pathFileOut
	 *            String - путь к файлу для записи
	 * @param massStrForRec
	 *            String [] - массив строк для записи
	 * @return boolean - тру либо фолс в зависимости от результата записи файла
	 * @throws Exception
	 */
	public static boolean recMassStr(String pathFileOut, String[] massStrForRec)
			throws Exception {

		BufferedWriter fBufWr = new BufferedWriter(new FileWriter(pathFileOut));

		for (int i = 0; i < massStrForRec.length; i++) {
			fBufWr.write(massStrForRec[i]);
			fBufWr.newLine();
		}// for
		fBufWr.close();
		return checkRecFile(pathFileOut);
	}// recMassStr ()

// ************************************************************************************
	/**
	 * Метод проверяет произведена ли запись в файл
	 * 
	 * @param pathFileOut
	 *            String - путь к файлу
	 * @return boolean - тру, если raf.length() > 0, иначе фолс
	 * @throws IOException
	 */
	public static boolean checkRecFile(String pathFileOut) throws IOException {

		boolean retVal = false;

		RandomAccessFile raf = new RandomAccessFile(pathFileOut, "r");
		if (raf.length() > 0) {
			retVal = true;
		}// if
		else
			retVal = false;
		raf.close();
		return retVal;
	}// checkRecFile ()

// ******************************************************************************

	/**
	 * Метод находит позиции непустых строк в файле, выраженный в байтах
	 * 
	 * @param pathFileIn
	 *            String - путь к файлу
	 * @return int [] - массив позиций непустых строк в файле, выраженный в
	 *         байтах
	 * @throws Exception
	 */
	public static int[] countStrInFile(String pathFileIn) throws Exception {

		RandomAccessFile raf = new RandomAccessFile(pathFileIn, "r");
		int count = 0; // кол-во непустых строк файла

		while (raf.getFilePointer() < raf.length()) {
			if (raf.readLine().trim().length() > 0) {
				count++;
			}// if
		}// while

		int[] massPosNoneEmptyStr = new int[count];
		count = 0;
		raf.seek(0);

		while (raf.getFilePointer() < raf.length()) {

			int posBeginStr = (int) raf.getFilePointer();
			String buf = raf.readLine().trim();

			if (buf.length() > 0) {
				massPosNoneEmptyStr[count] = posBeginStr;
				count++;
			}// if
		}// while
		raf.close();
		return massPosNoneEmptyStr;
	}// countStrInFile

// ******************************************************************************
	/**
	 * Метод считывает файл и возвращает массив строк
	 * 
	 * @param pathFileIn
	 *            String - путь к файлу для считывания
	 * @return String [] - массив считанных строк
	 * @throws Exception
	 */
	public static String[] readFile(String pathFileIn) throws Exception {

		RandomAccessFile raf = new RandomAccessFile(new File(pathFileIn), "r");

		int[] massPosStr = countStrInFile(pathFileIn);// метод вернет позиции
														// непустых строк файла
		String[] massStr = new String[massPosStr.length];

		for (int i = 0; i < massStr.length; i++) {
			raf.seek(massPosStr[i]);// устанавливаем каретку в позицию непустой
									// строки
			massStr[i] = new String(raf.readLine().getBytes("ISO-8859-1"),
					"Cp1251").trim();
		}// for

		raf.close();
		return massStr;
	}// readFile

// ******************************************************
	/**
	 * Метод "склеивает" ячейки двух одномерных массивов (arr1.length =
	 * arr2.length) без пробела и др. разделителей, при этом номера склеиваемых
	 * ячеек задаются
	 * 
	 * @param arr1
	 *            String [] - массив1 для склеивания
	 * @param numCell1
	 *            int [] - номера ячеек массива1 для склеивания
	 * @param arr2
	 *            String [] - массив2 для склеивания
	 * @param numCell2
	 *            int [] - номера ячеек массива2 для склеивания
	 * @return String [] - массив "склеенных" ячеек
	 */
	public static String[] glueCellsArrays(String[] arr1, int[] numCell1,
			String[] arr2, int[] numCell2) {
		String[] arrRes = new String[numCell1.length];
		for (int i = 0; i < arrRes.length; i++) {
			arrRes[i] = arr1[numCell1[i]] + arr2[numCell2[i]];
		}// for
		return arrRes;
	}// glueCellsArrays ()
//******************************************************
	/**
	 * Метод "склеивает" ячейки трех одномерных массивов (arr1.length =
	 * arr2.length = arr3.length) с разделителем (указывается в параметре)
	 * 
	 * @param arr1
	 *            String [] - массив1 для склеивания
	 * @param arr2
	 *            String [] - массив2 для склеивания
	 * @param arr3
	 *            String [] - массив3 для склеивания
	 * @param delim
	 *            String - разделитель
	 * @return String [] - массив "склеенных" ячеек
	 */
	public static String[] glueCellsArrays(String[] arr1, String[] arr2, String[] arr3, String delim) {
		String[] arrResult = new String[arr1.length];
		for (int i = 0; i < arrResult.length; i++) {
			arrResult[i] = arr1[i] + delim + arr2[i] + delim + arr3[i];
		}// for
		return arrResult;
	}// glueCellsArrays ()
//*********************************************************
	/**
	 * Метод "склеивает" ячейки двух одномерных массивов (arr1.length =
	 * arr2.length) при этом вставляет разделитель (delim)
	 * 
	 * @param arr1
	 *            String [] - массив1 для склеивания
	 * @param arr2
	 *            String [] - массив2 для склеивания
	 * @param delim
	 *            - разделитель
	 * @return String [] - массив "склеенных" ячеек
	 */
	public static String[] glueCellsArrays(String[] arr1, String [] arr2, String delim) {

		String[] arrRes = new String[arr1.length];

		for (int i = 0; i < arrRes.length; i++) {
			arrRes[i] = arr1[i] + delim + arr2[i];
		}// for

		return arrRes;
	}// glueCellsArrays
//******************************************************************************
	/** Метод генерирует массив случайных чисел в заданном диапазоне
	 * 
	 * @param quantityNum int - количество генераций
	 * @param num1 int - нижняя граница диапазона
	 * @param num2 int - верхняя граница диапазона
	 * @return int[] - массив случайных чисел
	 * @throws Exception
	 */
	
	public static int[] createArrRandomNum(int quantityNum, int num1, int num2) {

		Random rndm = new Random();
		int[] arrRandomNum = new int[quantityNum];

		if (num2 > num1) {
			for (int i = 0; i < quantityNum; i++) {
				arrRandomNum[i] = num1 + rndm.nextInt((int) (num2 - num1));
			}// for
		}// if
		else
			System.out
					.println("ВВеден некорректный диапазон значений: Параметр2 меньше параметра1");

		return arrRandomNum;
	}// ArrRandomNum

// ******************************************************
	/** Метод генерирует случайное число в заданном диапазоне
	 * 
	 * @param num1 long - нижняя граница диапазона
	 * @param num2 long - верхняя граница диапазона
	 * @return int[] - массив случайных чисел
	 * @throws Exception
	 */
	public static long generateRandomNum(long num1, long num2) {

		Random rndm = new Random();
		long random = 0;

		if (num2 > num1) {
			random = num1 + rndm.nextInt((int) (num2 - num1));
		}// if
		else
			System.out
					.println("ВВеден некорректный диапазон значений: Параметр2 меньше параметра1");

		return random;
	}// randomNum
// ******************************************************

	/**
	 * Метод генерирует заданное число номеров паспортов
	 * (серия одна - для простоты)
	 * 
	 * @param amountGeneration
	 *            				int - количество генераций
	 * @return String [] - массив номеров паспортов
	 */
	public static String[] generateRandomNumPass (int amountGeneration) {

		Random rndm = new Random();
		String [] arrNumPass = new String [amountGeneration];

			for (int i = 0; i < amountGeneration; i++) {
				arrNumPass[i] = "HC" + (111111 + rndm.nextInt((int) (999999 - 111111)));
			}// for
		return arrNumPass;
	}// generateRandomNumPass
// ******************************************************
		/**
		 * Метод генерирует заданное число дат выдачи паспортов
		 * 
		 * @param amountGeneration
		 *            				int - количество генераций
		 * @return String [] - массив дат выдачи паспортов
		 */
	public static String[] generateRandomDatePassport (int amountGeneration) {

		Random rndm = new Random();
		NumberFormat formatter = NumberFormat.getNumberInstance();
		
		String [] arrDatePass = new String [amountGeneration];
		for (int i = 0; i < amountGeneration; i++) {

			String year = "" + (1940 + rndm.nextInt((int) (2000 - 1940)));
			
			formatter.setMinimumIntegerDigits(2);
			String month = formatter.format(1 + rndm.nextInt((int) (12 - 1)));
			
			String date = formatter.format(1 + rndm.nextInt((int) (31 - 1)));
			arrDatePass[i] = year + "." + month + "." + date;
		}// for
		return arrDatePass;
	}// generateRandomNumPass
// ******************************************************


}//class
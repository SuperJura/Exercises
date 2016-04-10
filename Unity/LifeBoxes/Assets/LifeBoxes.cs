using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Globalization;
using System.IO;
using UnityEngine;

namespace Assets
{
    public class LifeBoxes : MonoBehaviour
    {
        private DateTime birthDate;
        private int boxSize;

        private string dateFormat;
        private bool drawBoxes;
        private string errorMsg;
        private string inputDay;
        private string inputMonth;
        private string inputYear;
        private int numberOfMonths;
        private string path;

        private int selectedMonth;
        private Dictionary<int, List<string>> eventList;    //month, event discription

        private void Awake()
        {
            dateFormat = "dd-MM-yyyy";
            inputDay = "DD";
            inputMonth = "MM";
            inputYear = "YYYY";
            errorMsg = "";

            boxSize = 25;

            path = Application.dataPath + "\\birth.txt";
            eventList = new Dictionary<int, List<string>>();
            selectedMonth = -1;
        }

        private void Start()
        {
            if (File.Exists(path))
            {
                try
                {
                    string inputDate = File.ReadAllText(path);
                    birthDate = DateTime.ParseExact(inputDate, dateFormat, null);
                    CalculateNumberOfMonths();
                    drawBoxes = true;
                }
                catch (Exception)
                {
                    drawBoxes = false;
                }
            }
        }

        private void CalculateNumberOfMonths()
        {
            numberOfMonths = (DateTime.Today.Month - birthDate.Month) + 12 * (DateTime.Today.Year - birthDate.Year);
            Debug.Log(numberOfMonths);
        }

        private void OnGUI()
        {
            if (drawBoxes)
            {
                int months = 0;
                int year = -1;
                for (int i = 0; i < 36; i++)
                {
                    for (int j = 0; j < 30; j++)
                    {
                        GUI.color = months <= numberOfMonths ? Color.red : Color.white;
                        if (months % 12 == 0)
                        {
                            year++;
                        }
                        if(GUI.Button(new Rect(50 + i*(boxSize + 5), 50 + j*(boxSize + 5), boxSize, boxSize), (year).ToString()))
                        {
                            selectedMonth = months;
                        }
                        months++;
                    }
                }
                if (selectedMonth != -1)
                {
                    if (eventList.ContainsKey(selectedMonth))
                    {
                        //ispisi evente
                    }
                }
            }
            else
            {
                GUI.color = Color.black;
                GUI.Label(new Rect(100, 50, 100, 100), "Enter your birth date");
                inputDay = GUI.TextField(new Rect(100, 100, 30, 25), inputDay, 8);
                inputMonth = GUI.TextField(new Rect(130, 100, 30, 25), inputMonth, 8);
                inputYear = GUI.TextField(new Rect(160, 100, 50, 25), inputYear, 8);

                if (GUI.Button(new Rect(100, 150, 100, 50), "OK"))
                {
                    string inputDate = inputDay + "-" + inputMonth + "-" + inputYear;
                    Debug.Log(inputDate);
                    if (DateTime.TryParseExact(inputDate, dateFormat, null, DateTimeStyles.None, out birthDate))
                    {
                        Debug.Log("Drawing boxes");
                        File.WriteAllText(path, inputDate);
                        CalculateNumberOfMonths();
                        drawBoxes = true;
                    }
                    else
                    {
                        Debug.Log("Date is in wrong format");
                        errorMsg = "Date is in wrong format\nUse DD-MM-YYYY";
                        drawBoxes = false;
                    }
                }
                GUI.color = Color.red;
                GUI.Label(new Rect(100, 200, 200, 50), errorMsg);
            }
        }

        private void OnApplicationQuit()
        {
            string fileName = "LifeBoxes_" + DateTime.Today.ToString(dateFormat) + ".png";
            Application.CaptureScreenshot(fileName);
            Debug.Log("Hello");
        }
    }
}
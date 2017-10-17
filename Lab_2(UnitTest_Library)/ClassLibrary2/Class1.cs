using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ClassLibrary2
{
    public class Calculator
    {
        public static double Sin(double value)
        {
            return Math.Sin(value);
        }

        public static int Add(int a, int b)
        {
            return a + b;
        }

        public static int Diff(int a, int b)
        {
            return a - b;
        }

        public static int Mul(int a, int b)
        {
            return a * b;
        }

        public static int Div(int a, int b)
        {
            return a / b;
        }

        public static double Cos(double value)
        {
            return Math.Cos(value);
        }
    }
}

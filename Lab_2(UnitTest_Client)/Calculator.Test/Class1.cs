using NUnit.Framework;
using ClassLibrary2;

namespace Calculators.Test
{
    [TestFixture]
    public class CalculatorTest
    {
        [Test]
        public void SinTest1()
        {
            double result = Calculator.Sin(10);
            Assert.AreEqual(0.1, result);
        }

        [Test]
        public void SinTest2()
        {
            double result = Calculator.Sin(10);
            Assert.AreEqual(0.2, result);
        }

        [Test]
        public void SinTest3()
        {
            double result = Calculator.Sin(10);
            Assert.AreEqual(0.3, result);
        }

        [Test]
        public void SinTest4()
        {
            double result = Calculator.Sin(10);
            Assert.AreEqual(0.4, result);
        }

        [Test]
        public void SinTest5()
        {
            double result = Calculator.Sin(10);
            Assert.AreEqual(0.5, result);
        }

        [Test]
        public void SumTest1()
        {
            int result = Calculator.Add(2, 2);
            Assert.AreEqual(4, result);
        }

        [Test]
        public void SumTest2()
        {
            int result = Calculator.Add(5, 2);
            Assert.AreEqual(6, result);
        }

        [Test]
        public void SumTest3()
        {
            int result = Calculator.Add(8, 7);
            Assert.AreEqual(15, result);
        }

        [Test]
        public void SumTest4()
        {
            int result = Calculator.Add(1, 1);
            Assert.AreEqual(0, result);
        }

        [Test]
        public void SumTest5()
        {
            int result = Calculator.Add(100, 2);
            Assert.AreEqual(102, result);
        }

        [Test]
        public void DiffTest1()
        {
            int result = Calculator.Diff(4, 2);
            Assert.AreEqual(2, result);
        }

        [Test]
        public void DiffTest2()
        {
            int result = Calculator.Diff(7, 7);
            Assert.AreEqual(1, result);
        }

        [Test]
        public void DiffTest3()
        {
            int result = Calculator.Diff(7, 1);
            Assert.AreEqual(4, result);
        }

        [Test]
        public void DiffTest4()
        {
            int result = Calculator.Diff(677, 745);
            Assert.AreEqual(10, result);
        }

        [Test]
        public void DiffTest5()
        {
            int result = Calculator.Diff(10, 5);
            Assert.AreEqual(5, result);
        }

        [Test]
        public void MullTest1()
        {
            int result = Calculator.Mul(7, 7);
            Assert.AreEqual(49, result);
        }

        [Test]
        public void MullTest2()
        {
            int result = Calculator.Mul(6, 7);
            Assert.AreEqual(42, result);
        }

        [Test]
        public void MullTest3()
        {
            int result = Calculator.Mul(5, 7);
            Assert.AreEqual(30, result);
        }

        [Test]
        public void MullTest4()
        {
            int result = Calculator.Mul(3, 7);
            Assert.AreEqual(11, result);
        }

        [Test]
        public void MullTest5()
        {
            int result = Calculator.Mul(9, 7);
            Assert.AreEqual(3, result);
        }

        [Test]
        public void DivTest1()
        {
            int result = Calculator.Div(14, 7);
            Assert.AreEqual(2, result);
        }

        [Test]
        public void DivTest2()
        {
            int result = Calculator.Div(21, 7);
            Assert.AreEqual(3, result);
        }

        [Test]
        public void DivTest3()
        {
            int result = Calculator.Div(49, 7);
            Assert.AreEqual(6, result);
        }

        [Test]
        public void DivTest4()
        {
            int result = Calculator.Div(7, 7);
            Assert.AreEqual(1, result);
        }

        [Test]
        public void DivTest5()
        {
            int result = Calculator.Div(35, 7);
            Assert.AreEqual(4, result);
        }

        [Test]
        public void CosTest1()
        {
            double result = Calculator.Cos(10);
            Assert.AreEqual(0.1, result);
        }

        [Test]
        public void CosTest2()
        {
            double result = Calculator.Cos(10);
            Assert.AreEqual(0.2, result);
        }

        [Test]
        public void CosTest3()
        {
            double result = Calculator.Cos(10);
            Assert.AreEqual(0.3, result);
        }

        [Test]
        public void CosTest4()
        {
            double result = Calculator.Cos(10);
            Assert.AreEqual(0.4, result);
        }

        [Test]
        public void CosTest5()
        {
            double result = Calculator.Cos(10);
            Assert.AreEqual(0.5, result);
        }
    }     
}


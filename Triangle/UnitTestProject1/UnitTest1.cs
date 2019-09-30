using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

using ClassLibrary;
namespace UnitTestProject1
{
    [TestClass]
    public class UnitTest1
    {
        [TestMethod]
        public void TestMethod1()
        {
            Triangle t = new Triangle();
            Assert.AreEqual(true, t.CheckTriangle(3, 4, 5));
        }
        [TestMethod]
        public void TestMethod2()
        {
            Triangle t = new Triangle();
            Assert.AreEqual(false, t.CheckTriangle(1, 1, 2));
        }
        [TestMethod]
        public void TestMethod3()
        {
            Triangle t = new Triangle();
            Assert.AreEqual(false, t.CheckTriangle(1, 2, 1));
        }
        [TestMethod]
        public void TestMethod4()
        {
            Triangle t = new Triangle();
            Assert.AreEqual(false, t.CheckTriangle(2, 1, 1));
        }
        [TestMethod]
        public void TestMethod5()
        {
            Triangle t = new Triangle();
            Assert.AreEqual(false, t.CheckTriangle(0, 4, 5));
        }
        [TestMethod]
        public void TestMethod6()
        {
            Triangle t = new Triangle();
            Assert.AreEqual(false, t.CheckTriangle(3, 0, 5));
        }
        [TestMethod]
        public void TestMethod7()
        {
            Triangle t = new Triangle();
            Assert.AreEqual(false, t.CheckTriangle(3, 4, 0));
        }
        [TestMethod]
        public void TestMethod8()
        {
            Triangle t = new Triangle();
            Assert.AreEqual(false, t.CheckTriangle(3, 0, 5));
        }
        [TestMethod]
        public void TestMethod9()
        {
            Triangle t = new Triangle();
            Assert.AreEqual(false, t.CheckTriangle(-3, 4, 5));
        }
        [TestMethod]
        public void TestMethod10()
        {
            Triangle t = new Triangle();
            Assert.AreEqual(false, t.CheckTriangle(3, -4, 5));
        }
        [TestMethod]
        public void TestMethod11()
        {
            Triangle t = new Triangle();
            Assert.AreEqual(false, t.CheckTriangle(3, 4, -5));
        }
        [TestMethod]
        public void TestMethod12()
        {
            Triangle t = new Triangle();
            Assert.AreEqual(true, t.CheckTriangle(3, 3, 3));
        }
    }
}

import org.scalatest.FunSuite

/**
  * Not working. Will try in SBT later, sounds like it may be IDEA.
  */
object ManagerTest extends FunSuite {
  test("toString test"){
    val employee = new Manager("Joe")
    assert("My name is: Joe (Mgr)" == employee.toString)
  }
}


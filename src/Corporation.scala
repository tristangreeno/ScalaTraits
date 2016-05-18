import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.util.Random

/**
  * This program uses Random to produce a random string of alphanumeric characters for each worker and manager.
  * The user enters either Wrk or Mgr to show only the managers or workers.
  */
object Corporation {
  var employees = new ListBuffer[Employee]

  for(i <- 1 to 10) employees += new Manager(Random.alphanumeric.take(10).mkString)
  for(i <- 1 to 10) employees += new Worker(Random.alphanumeric.take(9).mkString)

  val employeesList = employees.toList
  val hashMap: mutable.HashMap[String, String] = new mutable.HashMap

  def prompt(s: String): String = {
    println(s)
    io.StdIn.readLine()
  }

  def main(args: Array[String]) {
    employeesList.foreach(employee => {
      hashMap.put(employee.name, employee.toString)
    })

    val filter: String = prompt("Please enter a title to filter [Wkr (Worker) or Mgr (Manager)]:")
    hashMap.filter(map => map._2.endsWith(s"($filter)"))
      .foreach(map => { println(map._2) })
  }

}

class Manager(n: String) extends Employee {
  override val name: String = n
  override val title: String = "Mgr"
}

class Worker(n: String) extends Employee {
  override val name: String = n
  override val title: String = "Wkr"
}

trait Employee {
  val name: String
  val title: String
  override def toString = {
    s"My encrypted ID is: $name ($title)"
  }
}

package cse512

import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.Calendar

object HotcellUtils {
  val coordinateStep = 0.01

  def CalculateCoordinate(inputString: String, coordinateOffset: Int): Int =
  {
    // Configuration variable:
    // Coordinate step is the size of each cell on x and y
    var result = 0
    coordinateOffset match
    {
      case 0 => result = Math.floor((inputString.split(",")(0).replace("(","").toDouble/coordinateStep)).toInt
      case 1 => result = Math.floor(inputString.split(",")(1).replace(")","").toDouble/coordinateStep).toInt
      // We only consider the data from 2009 to 2012 inclusively, 4 years in total. Week 0 Day 0 is 2009-01-01
      case 2 => {
        val timestamp = HotcellUtils.timestampParser(inputString)
        result = HotcellUtils.dayOfMonth(timestamp) // Assume every month has 31 days
      }
    }
    return result
  }

  def timestampParser (timestampString: String): Timestamp =
  {
    val dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
    val parsedDate = dateFormat.parse(timestampString)
    val timeStamp = new Timestamp(parsedDate.getTime)
    return timeStamp
  }

  def dayOfYear (timestamp: Timestamp): Int =
  {
    val calendar = Calendar.getInstance
    calendar.setTimeInMillis(timestamp.getTime)
    return calendar.get(Calendar.DAY_OF_YEAR)
  }

  def dayOfMonth (timestamp: Timestamp): Int =
  {
    val calendar = Calendar.getInstance
    calendar.setTimeInMillis(timestamp.getTime)
    return calendar.get(Calendar.DAY_OF_MONTH)
  }

  def squared(a:Int):Double=
  {
    return (a*a).toDouble;
  }
  
  def CountNeighbours(minX: Int, minY: Int, minZ: Int, maxX: Int, maxY: Int, maxZ: Int, inputX: Int, inputY: Int, inputZ: Int): Int = 
  {
    var cellcount = 0;
    val cond1 = 7
    val cond2 =11
    val cond3 =17
    val cond4 =26
      
    if (inputX == minX || inputX == maxX) {
      cellcount += 1;
    }

    if (inputY == minY || inputY == maxY) {
      cellcount += 1;
    }

    if (inputZ == minZ || inputZ == maxZ) {
      cellcount += 1;
    }

    if (cellcount == 1) {
      return cond3;
    } 
    else if (cellcount == 2)
    {
      return cond2;
    }
    else if (cellcount == 3)
    {
      return cond1;
    } 
    else
    {
      return cond4;
    }
  }

  def gettisordstatistic(x: Int, y: Int, z: Int, mean:Double, sd: Double, countn: Int, sumn: Int, numcells: Int): Double =
  {
    val numerator = (sumn.toDouble - (mean*countn.toDouble))
    val denominator = sd*math.sqrt((((numcells.toDouble*countn.toDouble) -(countn.toDouble*countn.toDouble))/(numcells.toDouble-1.0).toDouble).toDouble).toDouble
    return (numerator/denominator).toDouble
  }
  // YOU NEED TO CHANGE THIS PART
}

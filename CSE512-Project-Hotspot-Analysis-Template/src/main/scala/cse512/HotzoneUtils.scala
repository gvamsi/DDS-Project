package cse512

object HotzoneUtils {

  def ST_Contains(queryRectangle: String, pointString: String ): Boolean = {
    // YOU NEED TO CHANGE THIS PART
    //return true // YOU NEED TO CHANGE THIS PART

    try {
          var rect = new Array[String](4)
          rect = queryRectangle.split(",")
          var rect_x1 = rect(0).trim.toDouble
          var rect_y1 = rect(1).trim.toDouble
          var rect_x2 = rect(2).trim.toDouble
          var rect_y2 = rect(3).trim.toDouble
            
          var point = new Array[String](2)
          point= pointString.split(",")          
          var point_x=point(0).trim.toDouble
          var point_y=point(1).trim.toDouble
          

          var lower_x =0.0
          var higher_x =0.0
          
          if (rect_x1 < rect_x2)
          {
            lower_x = rect_x1
            higher_x = rect_x2
          }
          else
          {
            lower_x = rect_x2
            higher_x = rect_x1
          }
          
          var lower_y = math.min(rect_y1, rect_y2)
          var higher_y = math.max(rect_y1, rect_y2)
          
          if(point_y > higher_y || point_x < lower_x || point_x>higher_x || point_y < lower_y)
            return false
          else
            return true
        }
        catch {
            case _: Throwable => return false
        }
  // YOU NEED TO CHANGE THIS PART
}

object HelloWorld {
    def ST_Contains(x:String, y:String): Boolean = {
        try {
          var rect = new Array[String](4)
          rect = x.split(",")
          var rect_x1 = rect(0).trim.toDouble
          var rect_y1 = rect(1).trim.toDouble
          var rect_x2 = rect(2).trim.toDouble
          var rect_y2 = rect(3).trim.toDouble
            
          var point = new Array[String](2)
          point= y.split(",")          
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
      }

    def ST_Within(x:String, y:String, z:Double): Boolean = {
        try {
          var point1 = new Array[String](2)
          point1 = x.split(",")

          var point1_x= point1(0).trim.toDouble
          var point1_y= point1(1).trim.toDouble
        
          var point2 = new Array[String](2)
          point2 = y.split(",")

          var point2_x=point2(0).trim.toDouble
          var point2_y=point2(1).trim.toDouble
          
          var maxDistance = z
          var pointDistance = Math.sqrt(Math.pow((point1_x - point2_x), 2) + Math.pow((point1_y - point2_y), 2))
          
          if(pointDistance <= maxDistance)
            return true 
          else
            return false
        }
        catch {
            case _: Throwable => return false
        }
      }
    
      def main(args: Array[String]) {
         //print("\nsum of x + y = " + ST_Contains("-88.331492,32.324142","-155.940114,19.081331,-155.618917,19.5307"))
         //print("\ndifference of x - y = " + ST_Within("-88.3333, 23.3333","23.3333, 30.0103", 111.87))
         /*print("border 1.9= " + ST_Within("1,1", "3,1",1.9))
         print("border 2= " + ST_Within("1,1", "3,1",2))
         print("border 2.1= " + ST_Within("1,1", "3,1",2.1))*/

         print("border " + ST_Contains("1,    1, 4,4  ","4,4"))
         //print("\nError:difference of x - y = " + ST_Within("-88.3333, 23.3333","saklfjas,adsflkadjfa", 111.87))

      }
}

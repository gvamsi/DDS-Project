object HelloWorld {
    def add(x:String, y:String): Boolean = {
          var point = new Array[String](2)
           point= x.split(",")
           print(point(0))
          
          
          var point_x=point(0).toDouble
          var point_y=point(1).toDouble
          
          var rect = new Array[String](4)
          rect = y.split(",")
          var rect_x1 = rect(0).toDouble
          var rect_y1 = rect(1).toDouble
          var rect_x2 = rect(2).toDouble
          var rect_y2 = rect(3).toDouble
          
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

    def subtract(x:String, y:String, z:Double): Boolean = {
          var point1 = new Array[String](2)
          point1 = x.split(",")
          print(point1(0))
          var point1_x= point1(0).toDouble
          var point1_y= point1(1).toDouble
        
          var point2 = new Array[String](2)
          point2 = y.split(",")
          print(point2(0))
          var point2_x=point2(0).toDouble
          var point2_y=point2(1).toDouble
          
          var maxDistance = z
          var pointDistance = Math.sqrt(Math.pow((point1_x - point2_x), 2) + Math.pow((point1_y - point2_y), 2))
          
          if(pointDistance <= maxDistance)
            return true
            
        else
            return false
        
          

      }
    
      def main(args: Array[String]) {
         print("sum of x + y = " + add("-88.331492,32.324142","-155.940114,19.081331,-155.618917,19.5307"));
         print("\ndifference of x - y = " + subtract("-88.3333, 23.3333","23.3333, 30.0103", 111.87))
      }
}
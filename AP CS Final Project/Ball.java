import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.*;

public class Ball extends PhysObj{

   private double speedX;
   private double speedY;
   private double SPEED = 1.5;
   private double posX;
   private double posY;
   private Color shade;
   private int radius;
   
   public Ball(int r, double xSpeed)
   {
      speedX = xSpeed;
      radius = r;
   }
   
   public Ball()
   {
      speedX = SPEED;
      radius = 5;
      posY = Manager.height/2;
      posX = Manager.width/2;
      speedY = 0;
      shade = Color.WHITE;
   }
   public void setColor(Color hue)
   {
      shade = hue;
   }
   public int getRadius()
   {
      return radius;
   }
   
   public void setSpeed(double speed)
   {
      SPEED = speed;
   }
   public void setPosition(double x, double y)
   {
      posX = x;
      posY = y;
   }
   public void setSpeed(double x, double y)
   {
      speedX = x;
      speedY = y;
   }
   
   public double getSpeedX()
   {
      return speedX;
   }
   public double getSpeedY()
   {
      return speedY;
   }
   public double getSpeed()
   {
      return Math.sqrt(speedX*speedX+speedY*speedY);
   }
   public double[] getSpeedSeperate()
   {
      double[] i = {speedX,speedY};
      return i;
   }
   public double getPosX()
   {
      return posX;
   }
   public double getPosY()
   {
      return posY;
   }
   public double[] getPos()
   {
      double[] i = {posX,posY};
      return i;
   }
   public int getHeight()
   {
      return 2*radius;
   }
   public int getWidth()
   {
      return 2*radius;
   }
   public void update()
   {
      posX += speedX;
      posY += speedY;
   }
   
   public double[] bounce(PhysObj player1, PhysObj player2, PhysObj power)
   {
      int height = Manager.height;
      if((posY >= height-radius-40 && speedY>0) || (posY <= 0+radius && speedY<0))
      {
         speedX = speedX;
         speedY = speedY * -1;
      }
      
      if(this.isColliding(player1))
      {
         double h = player1.getPosY();
         if(this.getPosY() < h + 16)
         {
            speedX = SPEED * Math.cos(Math.PI/4);
            speedY = -1 * SPEED * Math.sin(Math.PI/4);
         }
         else if(this.getPosY() < h + 32)
         {
            speedX = SPEED * Math.cos(Math.PI/12);
            speedY = -1 * SPEED * Math.sin(Math.PI/12);
         }
         else if(this.getPosY() < h + 48)
         {
            speedX = SPEED;
            speedY = 0;
         }
         else if(this.getPosY() < h + 64)
         {
            speedX = SPEED * Math.cos(Math.PI/12);
            speedY = SPEED * Math.sin(Math.PI/12);
         }
         else if(this.getPosY() < h + 80)
         {
            speedX = SPEED * Math.cos(Math.PI/12);
            speedY = SPEED * Math.sin(Math.PI/12);
         }      
      }
      
      else if(this.isColliding(player2))
      {
         double h = player2.getPosY();
         if(this.getPosY() < h + 16)
         {
            speedX = -1 * SPEED * Math.cos(Math.PI/4);
            speedY = -1 * SPEED * Math.sin(Math.PI/4);
         }
         else if(this.getPosY() < h + 32)
         {
            speedX = -1 * SPEED * Math.cos(Math.PI/12);
            speedY = -1 * SPEED * Math.sin(Math.PI/12);
         }
         else if(this.getPosY() < h + 48)
         {
            speedX = -1 * SPEED;
            speedY = 0;
         }
         else if(this.getPosY() < h + 64)
         {
            speedX = -1 * SPEED * Math.cos(Math.PI/12);
            speedY = SPEED * Math.sin(Math.PI/12);
         }
         else if(this.getPosY() < h + 80)
         {
            speedX = -1 * SPEED * Math.cos(Math.PI/12);
            speedY = SPEED * Math.sin(Math.PI/12);
         }
      }
      
      else if(this.isColliding(power))
      {
         //activate power
         //System.out.println("COLLISION");
      }
      
      double[] speeds = {speedX, speedY};
      return speeds;
   }  
   
   public void draw(Graphics g)
   {
      g.setColor(shade);
      int x = (int)posX;
      int y = (int)posY;
      int r = radius;
      g.fillOval(x-radius, y-radius, 2*r, 2*r);
   }
}
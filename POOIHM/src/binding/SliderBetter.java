/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binding;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

/**
 *
 * @author ahaye
 */
public class SliderBetter extends HBox {
    
    
   private Slider Test_slid = new Slider() ;
   private  Label l = new Label() ;
   private TextField tfValue = new TextField();
   private double min ;
   private double max ;
   private double value ;
   private DoubleProperty sliderCoeff ;
    
      public SliderBetter( String  sLabel , double min, double max, double value)
      {
         
            this.Test_slid.setMin(min);
             this.Test_slid.setMax(max);
            this.Test_slid.setValue(value);
            this.l.setText(sLabel);
          valueProperty();
           this.getChildren().add(l);
           this.getChildren().add(this.tfValue);
           this.getChildren().add(this.Test_slid);
           
           
           this.min = min ;
           this.max = max ;
           this.value = value ;
           

           this.Test_slid.setOrientation(Orientation.VERTICAL);

           this.l.textProperty().bind(Bindings.convert(sliderCoeff));
           
           this.tfValue.textProperty().bindBidirectional(this.sliderCoeff, new NumberStringConverter());
           
      }
        
        
   public double getMin() {
       return min ;
   }
   
    public double getMax() {
       return max ;
   }    
    
    
     public void setMin( double min) {
       this.min= min ;
   }
   
    public void setMax(double max) {
       this.max = max ;
   }    
        
    public DoubleProperty valueProperty(){
        return sliderCoeff = this.Test_slid.valueProperty() ;
    }
        
        
        

}

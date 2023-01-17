package Models;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.*;
public class Root{
    public String type;
    public String name;
    public Crs crs;
    public ArrayList<Feature> features;
    public Properties properties;
}

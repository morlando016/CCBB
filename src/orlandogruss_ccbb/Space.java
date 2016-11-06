/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package orlandogruss_ccbb;

/**
 *
 * @author orlando016
 */
public final class Space {
    // made private. might screw things up
    private String spaceType = "";    
    private Route currentRoute;
    private int routePos;
    
    Space(){
 
    }

    // constructer to initialize a space in a route. Called by initialize route
     Space(String newSpaceType, Route newRoute, int newRoutePos)
     {
        spaceType = newSpaceType;
        currentRoute = newRoute;
        routePos = newRoutePos;
    }
    
    public String getSpaceType()
    {
        return spaceType;
    }
    
    public int getRoutePos()
    {
        return routePos;
    }
    
    public Route getSpaceRoute()
    {
        return currentRoute;
    }

}

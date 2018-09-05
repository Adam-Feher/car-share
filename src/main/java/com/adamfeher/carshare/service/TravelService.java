package com.adamfeher.carshare.service;

import com.adamfeher.carshare.model.Position;
import com.adamfeher.carshare.model.Travel;
import org.springframework.stereotype.Service;

@Service
public class TravelService {


    public double calcDistance(Travel travel, Position currentPost) {
        double lon1 = travel.getStartingPosition().getLongitude();
        double lon2 = currentPost.getLongitude();
        double lat1 = travel.getStartingPosition().getLatitude();
        double lat2 = currentPost.getLatitude();

        double theta = lon1 - lon2;
        double dist = Math.sin(degToRad(lat1)) * Math.sin(degToRad(lat2)) + Math.cos(degToRad(lat1)) * Math.cos(degToRad(lat2)) * Math.cos(degToRad(theta));
        dist = Math.acos(dist);
        dist = radToDeg(dist);
        dist = dist * 60 * 1.1515;
        // returning it in Km
        return dist * 1.609344;
    }

    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    /*::	This function converts decimal degrees to radians						 :*/
    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    private static double degToRad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    /*::	This function converts radians to decimal degrees						 :*/
    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    private static double radToDeg(double rad) {
        return (rad * 180 / Math.PI);
    }
}

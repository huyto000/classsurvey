package com.entities;


import java.util.Arrays;
public class TinhToan{
   public static void main(String[] args){
         System.out.println(populationStandardDeviation(new int[]{1,1,1,1,3,3,3,2}));
   }
        
    /**
     * Standard deviation is a statistical measure of spread or variability.The
     * standard deviation is the root mean square (RMS) deviation of the values
     * from their arithmetic mean.
     *
     * <b>populationStandardDeviation</b> normalizes values by N, where N is the sample size. This the
     * <i>Population Standard Deviation</i>
     * @param values
     * @return
     */
    public static strictfp double populationStandardDeviation(int[] values) {
        double mean = mean(values);
        double n = values.length;
        double dv = 0;
        for (double d : values) {
            double dm = d - mean;
            dv += dm * dm;
        }
        
        return (double)Math.round(Math.sqrt(dv / n)*100)/100;
    }


    /**
     * Calculate the mean of an array of values
     *
     * @param values The values to calculate
     * @return The mean of the values
     */
    public static strictfp double mean(int[] values) {
        return sum(values) / values.length;
    }
    /**
     * Sum up all the values in an array
     *
     * @param values an array of values
     * @return The sum of all values in the Array
     */
    public static strictfp double sum(int[] values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("The data array either is null or does not contain any data.");
        }
        else {
            double sum = 0;
            for (int i = 0; i < values.length; i++) {
                sum += values[i];
            }
            return sum;
        }
    }
}
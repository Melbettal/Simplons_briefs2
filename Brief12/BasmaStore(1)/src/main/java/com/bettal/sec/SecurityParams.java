package com.bettal.sec;

public interface SecurityParams {
    public static final String JWT_HEADER_NAME="Authorization";
    public static final String SECRET="MM11EE22++//";
    public static final long EXPIRATION=10*24*3600; // expires in 10 days
    public static final String HEADER_PREFIX="Bearer ";
}
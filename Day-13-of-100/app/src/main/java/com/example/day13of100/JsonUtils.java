package com.example.day13of100;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {
    private final static String USER_ID = "id";
    private final static String USER_NAME = "name";
    private final static String USER_USERNAME = "username";
    private final static String USER_EMAIL = "email";
    private final static String USER_ADDRESS = "address";
    private final static String ADDRESS_STREET = "street";
    private final static String ADDRESS_SUITE = "suite";
    private final static String ADDRESS_CITY = "city";
    private final static String ADDRESS_ZIPCODE = "zipcode";
    private final static String ADDRESS_GEO = "geo";
    private final static String GEO_LAT = "lat";
    private final static String GEO_LNG = "lng";
    private final static String USER_PHONE = "phone";
    private final static String USER_WEBSITE = "website";
    private final static String USER_COMPANY = "company";
    private final static String COMPANY_NAME = "name";
    private final static String COMPANY_CATCHPHRASE = "catchPhrase";
    private final static String COMPANY_BS = "bs";

    public static List<User> parseJsonFromString(String json) {

        try {
            JSONArray usersJson = new JSONArray(json);
            List<User> userList = new ArrayList<>();
            for (int i = 0; i < usersJson.length(); i++) {
                JSONObject jsonObject = usersJson.getJSONObject(i);
                JSONObject objectAddress = jsonObject.getJSONObject(USER_ADDRESS);
                JSONObject objectCompany = jsonObject.getJSONObject(USER_COMPANY);
                JSONObject objectGeo = objectAddress.getJSONObject(ADDRESS_GEO);

                Geo geo = new Geo();
                geo.setLat(objectGeo.getString(GEO_LAT));
                geo.setLng(objectGeo.getString(GEO_LNG));

                Address address = new Address();
                address.setStreet(objectAddress.getString(ADDRESS_STREET));
                address.setSuite(objectAddress.getString(ADDRESS_SUITE));
                address.setCity(objectAddress.getString(ADDRESS_CITY));
                address.setZipcode(objectAddress.getString(ADDRESS_ZIPCODE));
                address.setGeo(geo);

                Company company = new Company();
                company.setName(objectCompany.getString(COMPANY_NAME));
                company.setCatchPhrase(objectCompany.getString(COMPANY_CATCHPHRASE));
                company.setBs(objectCompany.getString(COMPANY_BS));

                User user = new User();
                user.setId(jsonObject.optInt(USER_ID));
                user.setName(jsonObject.getString(USER_NAME));
                user.setUsername(jsonObject.getString(USER_USERNAME));
                user.setEmail(jsonObject.getString(USER_EMAIL));
                user.setAddress(address);
                user.setPhone(jsonObject.getString(USER_PHONE));
                user.setWebsite(jsonObject.getString(USER_WEBSITE));
                user.setCompany(company);

                userList.add(user);
            }
            return userList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}

package com.example.mvc;

import java.util.List;

public class Contract {

    interface View {
        void fetchedTestmodel(boolean status, List<Testmodel> testmodelList);
    }

    interface Userinteraction{
        void getTests(String userID, String labID);
    }
}

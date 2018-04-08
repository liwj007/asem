package com.liwj.asem.remote;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.liwj.asem.enums.UserTypeEnum;
import com.liwj.asem.remote.bo.*;

import java.util.ArrayList;
import java.util.List;

public class RemoteService {
    public String remoteURL = "http://39.108.238.199:8086";

    public List<College> getAllColleges() throws RemoteException {
        List<College> res = new ArrayList<>();
        Request request = null;
        try {
            request = new Request(remoteURL + "/college/api/findAllCollege");
        } catch (MethodNotSupportException e) {
            e.printStackTrace();
        }
        request.setUseSSL(false);

        Response response = HttpClientUtil.doRequest(request);
        Result result = JSON.parseObject(response.getResponseText(), Result.class);
        if (result.isStatus() == false) {
            throw new RemoteException();
        }
        List<JSONObject> data = result.getData();
        for (JSONObject item : data) {
            College college = JSON.parseObject(JSON.toJSONString(item), College.class);
            res.add(college);
        }
        return res;
    }

    public List<Major> getMajorsByCollege(long collegeID) throws RemoteException {
        List<Major> res = new ArrayList<>();
        Request request = null;
        try {
            request = new Request(remoteURL + "/jwt/major/api/findByCollege/" + collegeID);
        } catch (MethodNotSupportException e) {
            e.printStackTrace();
        }
        request.setUseSSL(false);

        Response response = HttpClientUtil.doRequest(request);
        Result result = JSON.parseObject(response.getResponseText(), Result.class);
        if (result.isStatus() == false) {
            throw new RemoteException();
        }
        List<JSONObject> data = result.getData();
        for (JSONObject item : data) {
            Major major = JSON.parseObject(JSON.toJSONString(item), Major.class);
            res.add(major);
        }
        return res;
    }

    public List<String> getGradesByCollege(long collegeID) throws RemoteException {
        Request request = null;
        try {
            request = new Request(remoteURL + "/jwt/grade/api/findByCollege/" + collegeID);
        } catch (MethodNotSupportException e) {
            e.printStackTrace();
        }
        request.setUseSSL(false);

        Response response = HttpClientUtil.doRequest(request);
        JSONObject jsonObject = JSON.parseObject(response.getResponseText());
        Boolean status = jsonObject.getBoolean("status");
        if (status == false) {
            throw new RemoteException();
        }

        JSONArray data = jsonObject.getJSONArray("data");
        List<String> res = new ArrayList<>();


        for (int i = 0; i < data.size(); i++) {
            String tmp = data.getString(i);
            res.add(tmp);
        }
        return res;
    }



    public List<String> getGradesByMajor(long majorID) throws RemoteException {
        List<String> res = new ArrayList<>();
        Request request = null;
        try {
            request = new Request(remoteURL + "/jwt/grade/api/findByMajor/" + majorID);
        } catch (MethodNotSupportException e) {
            e.printStackTrace();
        }
        request.setUseSSL(false);

        Response response = HttpClientUtil.doRequest(request);
        JSONObject jsonObject = JSON.parseObject(response.getResponseText());
        Boolean status = jsonObject.getBoolean("status");
        if (status == false) {
            throw new RemoteException();
        }
        JSONArray data = jsonObject.getJSONArray("data");
        for (int i = 0; i < data.size(); i++) {
            String tmp = data.getString(i);
            res.add(tmp);
        }
        return res;
    }

    public List<Classes> getClassesByCollegeAndGrade(long collegeID, int grade) throws RemoteException {
        List<Classes> res = new ArrayList<>();
        Request request = null;
        try {
            request = new Request(String.format("%s/class/api/findAll/%d/%d", remoteURL, collegeID, grade));
        } catch (MethodNotSupportException e) {
            e.printStackTrace();
        }
        request.setUseSSL(false);

        Response response = HttpClientUtil.doRequest(request);
        Result result = JSON.parseObject(response.getResponseText(), Result.class);
        if (result.isStatus() == false) {
            throw new RemoteException();
        }
        List<JSONObject> data = result.getData();
        for (Object item : data) {
            Classes classes = JSON.parseObject(JSON.toJSONString(item), Classes.class);
            res.add(classes);
        }
        return res;
    }

    public Integer getStudentCountByCollege(long collegeID) throws RemoteException {
        int res = 0;
        Request request = null;
        try {
            request = new Request(remoteURL + "/college/api/findStudentCount/" + collegeID);
        } catch (MethodNotSupportException e) {
            e.printStackTrace();
        }
        request.setUseSSL(false);

        Response response = HttpClientUtil.doRequest(request);
        Result2 result = JSON.parseObject(response.getResponseText(), Result2.class);
        if (result.isStatus() == false) {
            throw new RemoteException();
        }
        res = result.getData();
        return res;
    }


    public List<Integer> findRoleBySn(String sn) throws RemoteException {
        Request request = null;
        try {
            request = new Request(String.format("%s/role/api/findRoleBySn/%s", remoteURL, sn));
        } catch (MethodNotSupportException e) {
            e.printStackTrace();
        }
        request.setUseSSL(false);

        Response response = HttpClientUtil.doRequest(request);
        Result result = JSON.parseObject(response.getResponseText(), Result.class);
        if (result.isStatus() == false) {
            throw new RemoteException();
        }
        List<JSONObject> data = result.getData();
        if (data.size() == 0) {
            return null;
        }
        List<Integer> res = new ArrayList<>();
        for (JSONObject object : data) {
            res.add(object.getInteger("id"));
        }
        return res;
    }

    public NewStudent findStudentInfoBySn(String sn) throws RemoteException {
        Request request = null;
        try {
            request = new Request(String.format("%s/student/api/findStudentInfoBySn/%s", remoteURL, sn));
        } catch (MethodNotSupportException e) {
            e.printStackTrace();
        }
        request.setUseSSL(false);

        Response response = HttpClientUtil.doRequest(request);
        JSONObject json = JSON.parseObject(response.getResponseText());
        boolean status = json.getBoolean("status");
        if (status == false) {
            throw new RemoteException();
        }

        JSONObject data = json.getJSONObject("data");
        int userID = data.getInteger("userId");
        String name = data.getString("name");
        String grade = data.getString("grade");
        JSONArray colleges = data.getJSONArray("colleges");
        int collegeID = -1;
        String collegeName="";
        if (colleges.size() == 1) {
            JSONObject temp = colleges.getJSONObject(0);
            collegeID = temp.getInteger("id");
            collegeName = temp.getString("name");
        }
        JSONArray majors = data.getJSONArray("majors");
        String majorName="";
        int majorID = -1;
        if (majors.size() == 1) {
            JSONObject temp = majors.getJSONObject(0);
            majorID = temp.getInteger("id");
            majorName=temp.getString("name");
        }
        JSONArray classes = data.getJSONArray("classes");
        String className="";
        int classID = -1;
        if (classes.size() == 1) {
            JSONObject temp = classes.getJSONObject(0);
            classID = temp.getInteger("id");
            className=temp.getString("name");
        }
        NewStudent student = new NewStudent(userID, collegeID, majorID, classID, sn, name, grade);
        student.setCollegeName(collegeName);
        student.setMajorName(majorName);
        student.setClassName(className);
        return student;
    }

    public List<Item> findManageCollegesBySn(String sn) throws RemoteException {
        Request request = null;
        try {
            request = new Request(String.format("%s/college/api/findInstructionOrganizationBySn/%s", remoteURL, sn));
        } catch (MethodNotSupportException e) {
            e.printStackTrace();
        }
        request.setUseSSL(false);

        Response response = HttpClientUtil.doRequest(request);
        JSONObject json = JSON.parseObject(response.getResponseText());
        boolean status = json.getBoolean("status");
        if (status == false) {
            throw new RemoteException();
        }

        JSONArray data = json.getJSONArray("data");
        List<Item> res = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            JSONObject object = data.getJSONObject(i);
            Item tmp = new Item();
            tmp.setId(object.getInteger("id"));
            tmp.setName(object.getString("name"));
            res.add(tmp);
        }
        return res;
    }

    public List<Item> findGradeByAdvisor(String sn) throws RemoteException {
        Request request = null;
        try {
            request = new Request(String.format("%s/jwt/grade/api/findGradeByAdvisor/%s", remoteURL, sn));
        } catch (MethodNotSupportException e) {
            e.printStackTrace();
        }
        request.setUseSSL(false);

        Response response = HttpClientUtil.doRequest(request);
        JSONObject json = JSON.parseObject(response.getResponseText());
        boolean status = json.getBoolean("status");
        if (status == false) {
            throw new RemoteException();
        }

        JSONArray data = json.getJSONArray("data");
        List<Item> res = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            JSONObject object = data.getJSONObject(i);
            Item tmp = new Item();
            tmp.setId(object.getInteger("id"));
            tmp.setName(object.getString("grade"));
            res.add(tmp);
        }
        return res;
    }

    public String findCollegeNameById(Long id) throws RemoteException {
        Request request = null;
        try {
            request = new Request(String.format("%s/college/api/findCollegeById/%d", remoteURL, id));
        } catch (MethodNotSupportException e) {
            e.printStackTrace();
        }
        request.setUseSSL(false);

        Response response = HttpClientUtil.doRequest(request);
        JSONObject json = JSON.parseObject(response.getResponseText());
        boolean status = json.getBoolean("status");
        if (status == false) {
            throw new RemoteException();
        }

        JSONObject data = json.getJSONObject("data");
        String res = data.getString("name");
        return res;
    }

    public Integer findCollegeStudentCount(long collegeID) throws RemoteException {
        int res = 0;
        Request request = null;
        try {
            request = new Request(String.format("%s/college/api/findStudentCount/%d", remoteURL, collegeID));
        } catch (MethodNotSupportException e) {
            e.printStackTrace();
        }
        request.setUseSSL(false);

        Response response = HttpClientUtil.doRequest(request);
        Result2 result = JSON.parseObject(response.getResponseText(), Result2.class);
        if (result.isStatus() == false) {
            throw new RemoteException();
        }
        res = result.getData();
        return res;
    }

    public Integer getStudentCountByCollegeAndGrade(long collegeID, String grade) throws RemoteException {
        int res = 0;
        Request request = null;
        try {
            request = new Request(String.format("%s/college/api/findAll/%d/%s", remoteURL, collegeID, grade));
        } catch (MethodNotSupportException e) {
            e.printStackTrace();
        }
        request.setUseSSL(false);

        Response response = HttpClientUtil.doRequest(request);
        Result2 result = JSON.parseObject(response.getResponseText(), Result2.class);
        if (result.isStatus() == false) {
            throw new RemoteException();
        }
        res = result.getData();
        return res;
    }

    public String findUserNameBySn(String Sn) throws RemoteException {
        Request request = null;
        try {
            request = new Request(String.format("%s/user/api/getUserBySn/%s", remoteURL, Sn));
        } catch (MethodNotSupportException e) {
            e.printStackTrace();
        }
        request.setUseSSL(false);

        Response response = HttpClientUtil.doRequest(request);
        JSONObject json = JSON.parseObject(response.getResponseText());
        boolean status = json.getBoolean("status");
        if (status == false) {
            throw new RemoteException();
        }

        JSONObject data = json.getJSONObject("data");
        String res = data==null?"":data.getString("name");
        return res;
    }

    public List<Item> findClassByUnitAndGrade(String grade, int unitId) throws RemoteException {
        Request request = null;
        try {
            request = new Request(String.format("%s/class/api/findAll/%d/%s", remoteURL, unitId,grade));
        } catch (MethodNotSupportException e) {
            e.printStackTrace();
        }
        request.setUseSSL(false);

        Response response = HttpClientUtil.doRequest(request);
        JSONObject json = JSON.parseObject(response.getResponseText());
        boolean status = json.getBoolean("status");
        if (status == false) {
            throw new RemoteException();
        }

        JSONArray data = json.getJSONArray("data");
        List<Item> res = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            JSONObject object = data.getJSONObject(i);
            Item tmp = new Item();
            tmp.setId(object.getInteger("id"));
            tmp.setName(object.getString("name"));
            res.add(tmp);
        }
        return res;
    }


    public static void main(String[] args) {
        RemoteService service = new RemoteService();
        List<String> res = null;
        try {
            res = service.getGradesByCollege(26);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        System.out.println(res);
//        for (Classes item : res) {
//            System.out.println(item.getId() + "-" + item.getName());
//        }
//        for (Long item: res){
//            System.out.println(item);
//        }
    }
}

package service;

import java.util.List;

/**
 * 实现省市区三级联动
 */
public interface PCALinkage {

    public List<String> getProvinces();

    public List<String> getCities(String province);

    public List<String> getAreas(String city);

}

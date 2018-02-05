package dao;

import java.util.List;

public interface Address {

    public List<String> queryProvinces();

    public List<String> queryCities(String province);

    public List<String> queryAreas(String area);
}

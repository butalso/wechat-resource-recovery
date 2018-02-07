package dao;

import entity.Address;

import java.util.List;
import java.util.Map;

public interface AddressDao {

    public List<String> getProvinces();

    public List<String> getCities(String province);

    public List<String> getAreas(String city);

    public List<String> getHousingEstates(String area);

    public Address gethousingEstateAddress(int housing_estate_id);

    public Address getAreaAddress(String area_id);

}

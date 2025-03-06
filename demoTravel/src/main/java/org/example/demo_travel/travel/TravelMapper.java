package org.example.demo_travel.travel;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TravelMapper {
    public int insertOK(TravelVO vo);

    public int updateOK(TravelVO vo);

    public int deleteOK(TravelVO vo);

    public TravelVO selectOne(TravelVO vo);

    public List<TravelVO> selectAll(int startRow, int limit);

    public List<TravelVO> searchListDistrict(int startRow, int limit, String searchWord);

    public List<TravelVO> searchListPhone(int startRow, int limit, String searchWord);

    public int getTotalRecords();

    public int getSearchDistrictRecords(String searchWord);

    public int getSearchPhoneRecords(String searchWord);
}

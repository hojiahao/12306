package cn.edu.szu.train.member.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TicketExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TicketExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        protected void addCriterionForJDBCTime(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value.getTime()), property);
        }

        protected void addCriterionForJDBCTime(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Time> timeList = new ArrayList<>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                timeList.add(new java.sql.Time(iter.next().getTime()));
            }
            addCriterion(condition, timeList, property);
        }

        protected void addCriterionForJDBCTime(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value1.getTime()), new java.sql.Time(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMemberIdIsNull() {
            addCriterion("member_id is null");
            return (Criteria) this;
        }

        public Criteria andMemberIdIsNotNull() {
            addCriterion("member_id is not null");
            return (Criteria) this;
        }

        public Criteria andMemberIdEqualTo(Long value) {
            addCriterion("member_id =", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotEqualTo(Long value) {
            addCriterion("member_id <>", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThan(Long value) {
            addCriterion("member_id >", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThanOrEqualTo(Long value) {
            addCriterion("member_id >=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThan(Long value) {
            addCriterion("member_id <", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThanOrEqualTo(Long value) {
            addCriterion("member_id <=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdIn(List<Long> values) {
            addCriterion("member_id in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotIn(List<Long> values) {
            addCriterion("member_id not in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdBetween(Long value1, Long value2) {
            addCriterion("member_id between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotBetween(Long value1, Long value2) {
            addCriterion("member_id not between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andPassengerIdIsNull() {
            addCriterion("passenger_id is null");
            return (Criteria) this;
        }

        public Criteria andPassengerIdIsNotNull() {
            addCriterion("passenger_id is not null");
            return (Criteria) this;
        }

        public Criteria andPassengerIdEqualTo(Long value) {
            addCriterion("passenger_id =", value, "passengerId");
            return (Criteria) this;
        }

        public Criteria andPassengerIdNotEqualTo(Long value) {
            addCriterion("passenger_id <>", value, "passengerId");
            return (Criteria) this;
        }

        public Criteria andPassengerIdGreaterThan(Long value) {
            addCriterion("passenger_id >", value, "passengerId");
            return (Criteria) this;
        }

        public Criteria andPassengerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("passenger_id >=", value, "passengerId");
            return (Criteria) this;
        }

        public Criteria andPassengerIdLessThan(Long value) {
            addCriterion("passenger_id <", value, "passengerId");
            return (Criteria) this;
        }

        public Criteria andPassengerIdLessThanOrEqualTo(Long value) {
            addCriterion("passenger_id <=", value, "passengerId");
            return (Criteria) this;
        }

        public Criteria andPassengerIdIn(List<Long> values) {
            addCriterion("passenger_id in", values, "passengerId");
            return (Criteria) this;
        }

        public Criteria andPassengerIdNotIn(List<Long> values) {
            addCriterion("passenger_id not in", values, "passengerId");
            return (Criteria) this;
        }

        public Criteria andPassengerIdBetween(Long value1, Long value2) {
            addCriterion("passenger_id between", value1, value2, "passengerId");
            return (Criteria) this;
        }

        public Criteria andPassengerIdNotBetween(Long value1, Long value2) {
            addCriterion("passenger_id not between", value1, value2, "passengerId");
            return (Criteria) this;
        }

        public Criteria andPassengerNameIsNull() {
            addCriterion("passenger_name is null");
            return (Criteria) this;
        }

        public Criteria andPassengerNameIsNotNull() {
            addCriterion("passenger_name is not null");
            return (Criteria) this;
        }

        public Criteria andPassengerNameEqualTo(String value) {
            addCriterion("passenger_name =", value, "passengerName");
            return (Criteria) this;
        }

        public Criteria andPassengerNameNotEqualTo(String value) {
            addCriterion("passenger_name <>", value, "passengerName");
            return (Criteria) this;
        }

        public Criteria andPassengerNameGreaterThan(String value) {
            addCriterion("passenger_name >", value, "passengerName");
            return (Criteria) this;
        }

        public Criteria andPassengerNameGreaterThanOrEqualTo(String value) {
            addCriterion("passenger_name >=", value, "passengerName");
            return (Criteria) this;
        }

        public Criteria andPassengerNameLessThan(String value) {
            addCriterion("passenger_name <", value, "passengerName");
            return (Criteria) this;
        }

        public Criteria andPassengerNameLessThanOrEqualTo(String value) {
            addCriterion("passenger_name <=", value, "passengerName");
            return (Criteria) this;
        }

        public Criteria andPassengerNameLike(String value) {
            addCriterion("passenger_name like", value, "passengerName");
            return (Criteria) this;
        }

        public Criteria andPassengerNameNotLike(String value) {
            addCriterion("passenger_name not like", value, "passengerName");
            return (Criteria) this;
        }

        public Criteria andPassengerNameIn(List<String> values) {
            addCriterion("passenger_name in", values, "passengerName");
            return (Criteria) this;
        }

        public Criteria andPassengerNameNotIn(List<String> values) {
            addCriterion("passenger_name not in", values, "passengerName");
            return (Criteria) this;
        }

        public Criteria andPassengerNameBetween(String value1, String value2) {
            addCriterion("passenger_name between", value1, value2, "passengerName");
            return (Criteria) this;
        }

        public Criteria andPassengerNameNotBetween(String value1, String value2) {
            addCriterion("passenger_name not between", value1, value2, "passengerName");
            return (Criteria) this;
        }

        public Criteria andTrainDateIsNull() {
            addCriterion("train_date is null");
            return (Criteria) this;
        }

        public Criteria andTrainDateIsNotNull() {
            addCriterion("train_date is not null");
            return (Criteria) this;
        }

        public Criteria andTrainDateEqualTo(Date value) {
            addCriterionForJDBCDate("train_date =", value, "trainDate");
            return (Criteria) this;
        }

        public Criteria andTrainDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("train_date <>", value, "trainDate");
            return (Criteria) this;
        }

        public Criteria andTrainDateGreaterThan(Date value) {
            addCriterionForJDBCDate("train_date >", value, "trainDate");
            return (Criteria) this;
        }

        public Criteria andTrainDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("train_date >=", value, "trainDate");
            return (Criteria) this;
        }

        public Criteria andTrainDateLessThan(Date value) {
            addCriterionForJDBCDate("train_date <", value, "trainDate");
            return (Criteria) this;
        }

        public Criteria andTrainDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("train_date <=", value, "trainDate");
            return (Criteria) this;
        }

        public Criteria andTrainDateIn(List<Date> values) {
            addCriterionForJDBCDate("train_date in", values, "trainDate");
            return (Criteria) this;
        }

        public Criteria andTrainDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("train_date not in", values, "trainDate");
            return (Criteria) this;
        }

        public Criteria andTrainDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("train_date between", value1, value2, "trainDate");
            return (Criteria) this;
        }

        public Criteria andTrainDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("train_date not between", value1, value2, "trainDate");
            return (Criteria) this;
        }

        public Criteria andTrainCodeIsNull() {
            addCriterion("train_code is null");
            return (Criteria) this;
        }

        public Criteria andTrainCodeIsNotNull() {
            addCriterion("train_code is not null");
            return (Criteria) this;
        }

        public Criteria andTrainCodeEqualTo(String value) {
            addCriterion("train_code =", value, "trainCode");
            return (Criteria) this;
        }

        public Criteria andTrainCodeNotEqualTo(String value) {
            addCriterion("train_code <>", value, "trainCode");
            return (Criteria) this;
        }

        public Criteria andTrainCodeGreaterThan(String value) {
            addCriterion("train_code >", value, "trainCode");
            return (Criteria) this;
        }

        public Criteria andTrainCodeGreaterThanOrEqualTo(String value) {
            addCriterion("train_code >=", value, "trainCode");
            return (Criteria) this;
        }

        public Criteria andTrainCodeLessThan(String value) {
            addCriterion("train_code <", value, "trainCode");
            return (Criteria) this;
        }

        public Criteria andTrainCodeLessThanOrEqualTo(String value) {
            addCriterion("train_code <=", value, "trainCode");
            return (Criteria) this;
        }

        public Criteria andTrainCodeLike(String value) {
            addCriterion("train_code like", value, "trainCode");
            return (Criteria) this;
        }

        public Criteria andTrainCodeNotLike(String value) {
            addCriterion("train_code not like", value, "trainCode");
            return (Criteria) this;
        }

        public Criteria andTrainCodeIn(List<String> values) {
            addCriterion("train_code in", values, "trainCode");
            return (Criteria) this;
        }

        public Criteria andTrainCodeNotIn(List<String> values) {
            addCriterion("train_code not in", values, "trainCode");
            return (Criteria) this;
        }

        public Criteria andTrainCodeBetween(String value1, String value2) {
            addCriterion("train_code between", value1, value2, "trainCode");
            return (Criteria) this;
        }

        public Criteria andTrainCodeNotBetween(String value1, String value2) {
            addCriterion("train_code not between", value1, value2, "trainCode");
            return (Criteria) this;
        }

        public Criteria andCarriageIndexIsNull() {
            addCriterion("carriage_index is null");
            return (Criteria) this;
        }

        public Criteria andCarriageIndexIsNotNull() {
            addCriterion("carriage_index is not null");
            return (Criteria) this;
        }

        public Criteria andCarriageIndexEqualTo(Integer value) {
            addCriterion("carriage_index =", value, "carriageIndex");
            return (Criteria) this;
        }

        public Criteria andCarriageIndexNotEqualTo(Integer value) {
            addCriterion("carriage_index <>", value, "carriageIndex");
            return (Criteria) this;
        }

        public Criteria andCarriageIndexGreaterThan(Integer value) {
            addCriterion("carriage_index >", value, "carriageIndex");
            return (Criteria) this;
        }

        public Criteria andCarriageIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("carriage_index >=", value, "carriageIndex");
            return (Criteria) this;
        }

        public Criteria andCarriageIndexLessThan(Integer value) {
            addCriterion("carriage_index <", value, "carriageIndex");
            return (Criteria) this;
        }

        public Criteria andCarriageIndexLessThanOrEqualTo(Integer value) {
            addCriterion("carriage_index <=", value, "carriageIndex");
            return (Criteria) this;
        }

        public Criteria andCarriageIndexIn(List<Integer> values) {
            addCriterion("carriage_index in", values, "carriageIndex");
            return (Criteria) this;
        }

        public Criteria andCarriageIndexNotIn(List<Integer> values) {
            addCriterion("carriage_index not in", values, "carriageIndex");
            return (Criteria) this;
        }

        public Criteria andCarriageIndexBetween(Integer value1, Integer value2) {
            addCriterion("carriage_index between", value1, value2, "carriageIndex");
            return (Criteria) this;
        }

        public Criteria andCarriageIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("carriage_index not between", value1, value2, "carriageIndex");
            return (Criteria) this;
        }

        public Criteria andSeatRowIsNull() {
            addCriterion("seat_row is null");
            return (Criteria) this;
        }

        public Criteria andSeatRowIsNotNull() {
            addCriterion("seat_row is not null");
            return (Criteria) this;
        }

        public Criteria andSeatRowEqualTo(String value) {
            addCriterion("seat_row =", value, "seatRow");
            return (Criteria) this;
        }

        public Criteria andSeatRowNotEqualTo(String value) {
            addCriterion("seat_row <>", value, "seatRow");
            return (Criteria) this;
        }

        public Criteria andSeatRowGreaterThan(String value) {
            addCriterion("seat_row >", value, "seatRow");
            return (Criteria) this;
        }

        public Criteria andSeatRowGreaterThanOrEqualTo(String value) {
            addCriterion("seat_row >=", value, "seatRow");
            return (Criteria) this;
        }

        public Criteria andSeatRowLessThan(String value) {
            addCriterion("seat_row <", value, "seatRow");
            return (Criteria) this;
        }

        public Criteria andSeatRowLessThanOrEqualTo(String value) {
            addCriterion("seat_row <=", value, "seatRow");
            return (Criteria) this;
        }

        public Criteria andSeatRowLike(String value) {
            addCriterion("seat_row like", value, "seatRow");
            return (Criteria) this;
        }

        public Criteria andSeatRowNotLike(String value) {
            addCriterion("seat_row not like", value, "seatRow");
            return (Criteria) this;
        }

        public Criteria andSeatRowIn(List<String> values) {
            addCriterion("seat_row in", values, "seatRow");
            return (Criteria) this;
        }

        public Criteria andSeatRowNotIn(List<String> values) {
            addCriterion("seat_row not in", values, "seatRow");
            return (Criteria) this;
        }

        public Criteria andSeatRowBetween(String value1, String value2) {
            addCriterion("seat_row between", value1, value2, "seatRow");
            return (Criteria) this;
        }

        public Criteria andSeatRowNotBetween(String value1, String value2) {
            addCriterion("seat_row not between", value1, value2, "seatRow");
            return (Criteria) this;
        }

        public Criteria andSeatColIsNull() {
            addCriterion("seat_col is null");
            return (Criteria) this;
        }

        public Criteria andSeatColIsNotNull() {
            addCriterion("seat_col is not null");
            return (Criteria) this;
        }

        public Criteria andSeatColEqualTo(String value) {
            addCriterion("seat_col =", value, "seatCol");
            return (Criteria) this;
        }

        public Criteria andSeatColNotEqualTo(String value) {
            addCriterion("seat_col <>", value, "seatCol");
            return (Criteria) this;
        }

        public Criteria andSeatColGreaterThan(String value) {
            addCriterion("seat_col >", value, "seatCol");
            return (Criteria) this;
        }

        public Criteria andSeatColGreaterThanOrEqualTo(String value) {
            addCriterion("seat_col >=", value, "seatCol");
            return (Criteria) this;
        }

        public Criteria andSeatColLessThan(String value) {
            addCriterion("seat_col <", value, "seatCol");
            return (Criteria) this;
        }

        public Criteria andSeatColLessThanOrEqualTo(String value) {
            addCriterion("seat_col <=", value, "seatCol");
            return (Criteria) this;
        }

        public Criteria andSeatColLike(String value) {
            addCriterion("seat_col like", value, "seatCol");
            return (Criteria) this;
        }

        public Criteria andSeatColNotLike(String value) {
            addCriterion("seat_col not like", value, "seatCol");
            return (Criteria) this;
        }

        public Criteria andSeatColIn(List<String> values) {
            addCriterion("seat_col in", values, "seatCol");
            return (Criteria) this;
        }

        public Criteria andSeatColNotIn(List<String> values) {
            addCriterion("seat_col not in", values, "seatCol");
            return (Criteria) this;
        }

        public Criteria andSeatColBetween(String value1, String value2) {
            addCriterion("seat_col between", value1, value2, "seatCol");
            return (Criteria) this;
        }

        public Criteria andSeatColNotBetween(String value1, String value2) {
            addCriterion("seat_col not between", value1, value2, "seatCol");
            return (Criteria) this;
        }

        public Criteria andDepartureStationIsNull() {
            addCriterion("departure_station is null");
            return (Criteria) this;
        }

        public Criteria andDepartureStationIsNotNull() {
            addCriterion("departure_station is not null");
            return (Criteria) this;
        }

        public Criteria andDepartureStationEqualTo(String value) {
            addCriterion("departure_station =", value, "departureStation");
            return (Criteria) this;
        }

        public Criteria andDepartureStationNotEqualTo(String value) {
            addCriterion("departure_station <>", value, "departureStation");
            return (Criteria) this;
        }

        public Criteria andDepartureStationGreaterThan(String value) {
            addCriterion("departure_station >", value, "departureStation");
            return (Criteria) this;
        }

        public Criteria andDepartureStationGreaterThanOrEqualTo(String value) {
            addCriterion("departure_station >=", value, "departureStation");
            return (Criteria) this;
        }

        public Criteria andDepartureStationLessThan(String value) {
            addCriterion("departure_station <", value, "departureStation");
            return (Criteria) this;
        }

        public Criteria andDepartureStationLessThanOrEqualTo(String value) {
            addCriterion("departure_station <=", value, "departureStation");
            return (Criteria) this;
        }

        public Criteria andDepartureStationLike(String value) {
            addCriterion("departure_station like", value, "departureStation");
            return (Criteria) this;
        }

        public Criteria andDepartureStationNotLike(String value) {
            addCriterion("departure_station not like", value, "departureStation");
            return (Criteria) this;
        }

        public Criteria andDepartureStationIn(List<String> values) {
            addCriterion("departure_station in", values, "departureStation");
            return (Criteria) this;
        }

        public Criteria andDepartureStationNotIn(List<String> values) {
            addCriterion("departure_station not in", values, "departureStation");
            return (Criteria) this;
        }

        public Criteria andDepartureStationBetween(String value1, String value2) {
            addCriterion("departure_station between", value1, value2, "departureStation");
            return (Criteria) this;
        }

        public Criteria andDepartureStationNotBetween(String value1, String value2) {
            addCriterion("departure_station not between", value1, value2, "departureStation");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeIsNull() {
            addCriterion("departure_time is null");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeIsNotNull() {
            addCriterion("departure_time is not null");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeEqualTo(Date value) {
            addCriterionForJDBCTime("departure_time =", value, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("departure_time <>", value, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeGreaterThan(Date value) {
            addCriterionForJDBCTime("departure_time >", value, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("departure_time >=", value, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeLessThan(Date value) {
            addCriterionForJDBCTime("departure_time <", value, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("departure_time <=", value, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeIn(List<Date> values) {
            addCriterionForJDBCTime("departure_time in", values, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("departure_time not in", values, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("departure_time between", value1, value2, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("departure_time not between", value1, value2, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDestinationStationIsNull() {
            addCriterion("destination_station is null");
            return (Criteria) this;
        }

        public Criteria andDestinationStationIsNotNull() {
            addCriterion("destination_station is not null");
            return (Criteria) this;
        }

        public Criteria andDestinationStationEqualTo(String value) {
            addCriterion("destination_station =", value, "destinationStation");
            return (Criteria) this;
        }

        public Criteria andDestinationStationNotEqualTo(String value) {
            addCriterion("destination_station <>", value, "destinationStation");
            return (Criteria) this;
        }

        public Criteria andDestinationStationGreaterThan(String value) {
            addCriterion("destination_station >", value, "destinationStation");
            return (Criteria) this;
        }

        public Criteria andDestinationStationGreaterThanOrEqualTo(String value) {
            addCriterion("destination_station >=", value, "destinationStation");
            return (Criteria) this;
        }

        public Criteria andDestinationStationLessThan(String value) {
            addCriterion("destination_station <", value, "destinationStation");
            return (Criteria) this;
        }

        public Criteria andDestinationStationLessThanOrEqualTo(String value) {
            addCriterion("destination_station <=", value, "destinationStation");
            return (Criteria) this;
        }

        public Criteria andDestinationStationLike(String value) {
            addCriterion("destination_station like", value, "destinationStation");
            return (Criteria) this;
        }

        public Criteria andDestinationStationNotLike(String value) {
            addCriterion("destination_station not like", value, "destinationStation");
            return (Criteria) this;
        }

        public Criteria andDestinationStationIn(List<String> values) {
            addCriterion("destination_station in", values, "destinationStation");
            return (Criteria) this;
        }

        public Criteria andDestinationStationNotIn(List<String> values) {
            addCriterion("destination_station not in", values, "destinationStation");
            return (Criteria) this;
        }

        public Criteria andDestinationStationBetween(String value1, String value2) {
            addCriterion("destination_station between", value1, value2, "destinationStation");
            return (Criteria) this;
        }

        public Criteria andDestinationStationNotBetween(String value1, String value2) {
            addCriterion("destination_station not between", value1, value2, "destinationStation");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeIsNull() {
            addCriterion("arrival_time is null");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeIsNotNull() {
            addCriterion("arrival_time is not null");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeEqualTo(Date value) {
            addCriterionForJDBCTime("arrival_time =", value, "arrivalTime");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("arrival_time <>", value, "arrivalTime");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeGreaterThan(Date value) {
            addCriterionForJDBCTime("arrival_time >", value, "arrivalTime");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("arrival_time >=", value, "arrivalTime");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeLessThan(Date value) {
            addCriterionForJDBCTime("arrival_time <", value, "arrivalTime");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("arrival_time <=", value, "arrivalTime");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeIn(List<Date> values) {
            addCriterionForJDBCTime("arrival_time in", values, "arrivalTime");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("arrival_time not in", values, "arrivalTime");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("arrival_time between", value1, value2, "arrivalTime");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("arrival_time not between", value1, value2, "arrivalTime");
            return (Criteria) this;
        }

        public Criteria andSeatTypeIsNull() {
            addCriterion("seat_type is null");
            return (Criteria) this;
        }

        public Criteria andSeatTypeIsNotNull() {
            addCriterion("seat_type is not null");
            return (Criteria) this;
        }

        public Criteria andSeatTypeEqualTo(String value) {
            addCriterion("seat_type =", value, "seatType");
            return (Criteria) this;
        }

        public Criteria andSeatTypeNotEqualTo(String value) {
            addCriterion("seat_type <>", value, "seatType");
            return (Criteria) this;
        }

        public Criteria andSeatTypeGreaterThan(String value) {
            addCriterion("seat_type >", value, "seatType");
            return (Criteria) this;
        }

        public Criteria andSeatTypeGreaterThanOrEqualTo(String value) {
            addCriterion("seat_type >=", value, "seatType");
            return (Criteria) this;
        }

        public Criteria andSeatTypeLessThan(String value) {
            addCriterion("seat_type <", value, "seatType");
            return (Criteria) this;
        }

        public Criteria andSeatTypeLessThanOrEqualTo(String value) {
            addCriterion("seat_type <=", value, "seatType");
            return (Criteria) this;
        }

        public Criteria andSeatTypeLike(String value) {
            addCriterion("seat_type like", value, "seatType");
            return (Criteria) this;
        }

        public Criteria andSeatTypeNotLike(String value) {
            addCriterion("seat_type not like", value, "seatType");
            return (Criteria) this;
        }

        public Criteria andSeatTypeIn(List<String> values) {
            addCriterion("seat_type in", values, "seatType");
            return (Criteria) this;
        }

        public Criteria andSeatTypeNotIn(List<String> values) {
            addCriterion("seat_type not in", values, "seatType");
            return (Criteria) this;
        }

        public Criteria andSeatTypeBetween(String value1, String value2) {
            addCriterion("seat_type between", value1, value2, "seatType");
            return (Criteria) this;
        }

        public Criteria andSeatTypeNotBetween(String value1, String value2) {
            addCriterion("seat_type not between", value1, value2, "seatType");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
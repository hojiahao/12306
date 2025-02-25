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

        public Criteria andDateIsNull() {
            addCriterion("`date` is null");
            return (Criteria) this;
        }

        public Criteria andDateIsNotNull() {
            addCriterion("`date` is not null");
            return (Criteria) this;
        }

        public Criteria andDateEqualTo(Date value) {
            addCriterionForJDBCDate("`date` =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("`date` <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(Date value) {
            addCriterionForJDBCDate("`date` >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("`date` >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(Date value) {
            addCriterionForJDBCDate("`date` <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("`date` <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<Date> values) {
            addCriterionForJDBCDate("`date` in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("`date` not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("`date` between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("`date` not between", value1, value2, "date");
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

        public Criteria andRowIsNull() {
            addCriterion("`row` is null");
            return (Criteria) this;
        }

        public Criteria andRowIsNotNull() {
            addCriterion("`row` is not null");
            return (Criteria) this;
        }

        public Criteria andRowEqualTo(String value) {
            addCriterion("`row` =", value, "row");
            return (Criteria) this;
        }

        public Criteria andRowNotEqualTo(String value) {
            addCriterion("`row` <>", value, "row");
            return (Criteria) this;
        }

        public Criteria andRowGreaterThan(String value) {
            addCriterion("`row` >", value, "row");
            return (Criteria) this;
        }

        public Criteria andRowGreaterThanOrEqualTo(String value) {
            addCriterion("`row` >=", value, "row");
            return (Criteria) this;
        }

        public Criteria andRowLessThan(String value) {
            addCriterion("`row` <", value, "row");
            return (Criteria) this;
        }

        public Criteria andRowLessThanOrEqualTo(String value) {
            addCriterion("`row` <=", value, "row");
            return (Criteria) this;
        }

        public Criteria andRowLike(String value) {
            addCriterion("`row` like", value, "row");
            return (Criteria) this;
        }

        public Criteria andRowNotLike(String value) {
            addCriterion("`row` not like", value, "row");
            return (Criteria) this;
        }

        public Criteria andRowIn(List<String> values) {
            addCriterion("`row` in", values, "row");
            return (Criteria) this;
        }

        public Criteria andRowNotIn(List<String> values) {
            addCriterion("`row` not in", values, "row");
            return (Criteria) this;
        }

        public Criteria andRowBetween(String value1, String value2) {
            addCriterion("`row` between", value1, value2, "row");
            return (Criteria) this;
        }

        public Criteria andRowNotBetween(String value1, String value2) {
            addCriterion("`row` not between", value1, value2, "row");
            return (Criteria) this;
        }

        public Criteria andColIsNull() {
            addCriterion("col is null");
            return (Criteria) this;
        }

        public Criteria andColIsNotNull() {
            addCriterion("col is not null");
            return (Criteria) this;
        }

        public Criteria andColEqualTo(String value) {
            addCriterion("col =", value, "col");
            return (Criteria) this;
        }

        public Criteria andColNotEqualTo(String value) {
            addCriterion("col <>", value, "col");
            return (Criteria) this;
        }

        public Criteria andColGreaterThan(String value) {
            addCriterion("col >", value, "col");
            return (Criteria) this;
        }

        public Criteria andColGreaterThanOrEqualTo(String value) {
            addCriterion("col >=", value, "col");
            return (Criteria) this;
        }

        public Criteria andColLessThan(String value) {
            addCriterion("col <", value, "col");
            return (Criteria) this;
        }

        public Criteria andColLessThanOrEqualTo(String value) {
            addCriterion("col <=", value, "col");
            return (Criteria) this;
        }

        public Criteria andColLike(String value) {
            addCriterion("col like", value, "col");
            return (Criteria) this;
        }

        public Criteria andColNotLike(String value) {
            addCriterion("col not like", value, "col");
            return (Criteria) this;
        }

        public Criteria andColIn(List<String> values) {
            addCriterion("col in", values, "col");
            return (Criteria) this;
        }

        public Criteria andColNotIn(List<String> values) {
            addCriterion("col not in", values, "col");
            return (Criteria) this;
        }

        public Criteria andColBetween(String value1, String value2) {
            addCriterion("col between", value1, value2, "col");
            return (Criteria) this;
        }

        public Criteria andColNotBetween(String value1, String value2) {
            addCriterion("col not between", value1, value2, "col");
            return (Criteria) this;
        }

        public Criteria andDepartureIsNull() {
            addCriterion("departure is null");
            return (Criteria) this;
        }

        public Criteria andDepartureIsNotNull() {
            addCriterion("departure is not null");
            return (Criteria) this;
        }

        public Criteria andDepartureEqualTo(String value) {
            addCriterion("departure =", value, "departure");
            return (Criteria) this;
        }

        public Criteria andDepartureNotEqualTo(String value) {
            addCriterion("departure <>", value, "departure");
            return (Criteria) this;
        }

        public Criteria andDepartureGreaterThan(String value) {
            addCriterion("departure >", value, "departure");
            return (Criteria) this;
        }

        public Criteria andDepartureGreaterThanOrEqualTo(String value) {
            addCriterion("departure >=", value, "departure");
            return (Criteria) this;
        }

        public Criteria andDepartureLessThan(String value) {
            addCriterion("departure <", value, "departure");
            return (Criteria) this;
        }

        public Criteria andDepartureLessThanOrEqualTo(String value) {
            addCriterion("departure <=", value, "departure");
            return (Criteria) this;
        }

        public Criteria andDepartureLike(String value) {
            addCriterion("departure like", value, "departure");
            return (Criteria) this;
        }

        public Criteria andDepartureNotLike(String value) {
            addCriterion("departure not like", value, "departure");
            return (Criteria) this;
        }

        public Criteria andDepartureIn(List<String> values) {
            addCriterion("departure in", values, "departure");
            return (Criteria) this;
        }

        public Criteria andDepartureNotIn(List<String> values) {
            addCriterion("departure not in", values, "departure");
            return (Criteria) this;
        }

        public Criteria andDepartureBetween(String value1, String value2) {
            addCriterion("departure between", value1, value2, "departure");
            return (Criteria) this;
        }

        public Criteria andDepartureNotBetween(String value1, String value2) {
            addCriterion("departure not between", value1, value2, "departure");
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

        public Criteria andDestinationIsNull() {
            addCriterion("destination is null");
            return (Criteria) this;
        }

        public Criteria andDestinationIsNotNull() {
            addCriterion("destination is not null");
            return (Criteria) this;
        }

        public Criteria andDestinationEqualTo(String value) {
            addCriterion("destination =", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationNotEqualTo(String value) {
            addCriterion("destination <>", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationGreaterThan(String value) {
            addCriterion("destination >", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationGreaterThanOrEqualTo(String value) {
            addCriterion("destination >=", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationLessThan(String value) {
            addCriterion("destination <", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationLessThanOrEqualTo(String value) {
            addCriterion("destination <=", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationLike(String value) {
            addCriterion("destination like", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationNotLike(String value) {
            addCriterion("destination not like", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationIn(List<String> values) {
            addCriterion("destination in", values, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationNotIn(List<String> values) {
            addCriterion("destination not in", values, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationBetween(String value1, String value2) {
            addCriterion("destination between", value1, value2, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationNotBetween(String value1, String value2) {
            addCriterion("destination not between", value1, value2, "destination");
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
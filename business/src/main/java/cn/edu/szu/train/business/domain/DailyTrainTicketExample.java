package cn.edu.szu.train.business.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DailyTrainTicketExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DailyTrainTicketExample() {
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

        public Criteria andDeparturePinyinIsNull() {
            addCriterion("departure_pinyin is null");
            return (Criteria) this;
        }

        public Criteria andDeparturePinyinIsNotNull() {
            addCriterion("departure_pinyin is not null");
            return (Criteria) this;
        }

        public Criteria andDeparturePinyinEqualTo(String value) {
            addCriterion("departure_pinyin =", value, "departurePinyin");
            return (Criteria) this;
        }

        public Criteria andDeparturePinyinNotEqualTo(String value) {
            addCriterion("departure_pinyin <>", value, "departurePinyin");
            return (Criteria) this;
        }

        public Criteria andDeparturePinyinGreaterThan(String value) {
            addCriterion("departure_pinyin >", value, "departurePinyin");
            return (Criteria) this;
        }

        public Criteria andDeparturePinyinGreaterThanOrEqualTo(String value) {
            addCriterion("departure_pinyin >=", value, "departurePinyin");
            return (Criteria) this;
        }

        public Criteria andDeparturePinyinLessThan(String value) {
            addCriterion("departure_pinyin <", value, "departurePinyin");
            return (Criteria) this;
        }

        public Criteria andDeparturePinyinLessThanOrEqualTo(String value) {
            addCriterion("departure_pinyin <=", value, "departurePinyin");
            return (Criteria) this;
        }

        public Criteria andDeparturePinyinLike(String value) {
            addCriterion("departure_pinyin like", value, "departurePinyin");
            return (Criteria) this;
        }

        public Criteria andDeparturePinyinNotLike(String value) {
            addCriterion("departure_pinyin not like", value, "departurePinyin");
            return (Criteria) this;
        }

        public Criteria andDeparturePinyinIn(List<String> values) {
            addCriterion("departure_pinyin in", values, "departurePinyin");
            return (Criteria) this;
        }

        public Criteria andDeparturePinyinNotIn(List<String> values) {
            addCriterion("departure_pinyin not in", values, "departurePinyin");
            return (Criteria) this;
        }

        public Criteria andDeparturePinyinBetween(String value1, String value2) {
            addCriterion("departure_pinyin between", value1, value2, "departurePinyin");
            return (Criteria) this;
        }

        public Criteria andDeparturePinyinNotBetween(String value1, String value2) {
            addCriterion("departure_pinyin not between", value1, value2, "departurePinyin");
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

        public Criteria andDepartureIndexIsNull() {
            addCriterion("departure_index is null");
            return (Criteria) this;
        }

        public Criteria andDepartureIndexIsNotNull() {
            addCriterion("departure_index is not null");
            return (Criteria) this;
        }

        public Criteria andDepartureIndexEqualTo(Integer value) {
            addCriterion("departure_index =", value, "departureIndex");
            return (Criteria) this;
        }

        public Criteria andDepartureIndexNotEqualTo(Integer value) {
            addCriterion("departure_index <>", value, "departureIndex");
            return (Criteria) this;
        }

        public Criteria andDepartureIndexGreaterThan(Integer value) {
            addCriterion("departure_index >", value, "departureIndex");
            return (Criteria) this;
        }

        public Criteria andDepartureIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("departure_index >=", value, "departureIndex");
            return (Criteria) this;
        }

        public Criteria andDepartureIndexLessThan(Integer value) {
            addCriterion("departure_index <", value, "departureIndex");
            return (Criteria) this;
        }

        public Criteria andDepartureIndexLessThanOrEqualTo(Integer value) {
            addCriterion("departure_index <=", value, "departureIndex");
            return (Criteria) this;
        }

        public Criteria andDepartureIndexIn(List<Integer> values) {
            addCriterion("departure_index in", values, "departureIndex");
            return (Criteria) this;
        }

        public Criteria andDepartureIndexNotIn(List<Integer> values) {
            addCriterion("departure_index not in", values, "departureIndex");
            return (Criteria) this;
        }

        public Criteria andDepartureIndexBetween(Integer value1, Integer value2) {
            addCriterion("departure_index between", value1, value2, "departureIndex");
            return (Criteria) this;
        }

        public Criteria andDepartureIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("departure_index not between", value1, value2, "departureIndex");
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

        public Criteria andDestinationPinyinIsNull() {
            addCriterion("destination_pinyin is null");
            return (Criteria) this;
        }

        public Criteria andDestinationPinyinIsNotNull() {
            addCriterion("destination_pinyin is not null");
            return (Criteria) this;
        }

        public Criteria andDestinationPinyinEqualTo(String value) {
            addCriterion("destination_pinyin =", value, "destinationPinyin");
            return (Criteria) this;
        }

        public Criteria andDestinationPinyinNotEqualTo(String value) {
            addCriterion("destination_pinyin <>", value, "destinationPinyin");
            return (Criteria) this;
        }

        public Criteria andDestinationPinyinGreaterThan(String value) {
            addCriterion("destination_pinyin >", value, "destinationPinyin");
            return (Criteria) this;
        }

        public Criteria andDestinationPinyinGreaterThanOrEqualTo(String value) {
            addCriterion("destination_pinyin >=", value, "destinationPinyin");
            return (Criteria) this;
        }

        public Criteria andDestinationPinyinLessThan(String value) {
            addCriterion("destination_pinyin <", value, "destinationPinyin");
            return (Criteria) this;
        }

        public Criteria andDestinationPinyinLessThanOrEqualTo(String value) {
            addCriterion("destination_pinyin <=", value, "destinationPinyin");
            return (Criteria) this;
        }

        public Criteria andDestinationPinyinLike(String value) {
            addCriterion("destination_pinyin like", value, "destinationPinyin");
            return (Criteria) this;
        }

        public Criteria andDestinationPinyinNotLike(String value) {
            addCriterion("destination_pinyin not like", value, "destinationPinyin");
            return (Criteria) this;
        }

        public Criteria andDestinationPinyinIn(List<String> values) {
            addCriterion("destination_pinyin in", values, "destinationPinyin");
            return (Criteria) this;
        }

        public Criteria andDestinationPinyinNotIn(List<String> values) {
            addCriterion("destination_pinyin not in", values, "destinationPinyin");
            return (Criteria) this;
        }

        public Criteria andDestinationPinyinBetween(String value1, String value2) {
            addCriterion("destination_pinyin between", value1, value2, "destinationPinyin");
            return (Criteria) this;
        }

        public Criteria andDestinationPinyinNotBetween(String value1, String value2) {
            addCriterion("destination_pinyin not between", value1, value2, "destinationPinyin");
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

        public Criteria andArrivalIndexIsNull() {
            addCriterion("arrival_index is null");
            return (Criteria) this;
        }

        public Criteria andArrivalIndexIsNotNull() {
            addCriterion("arrival_index is not null");
            return (Criteria) this;
        }

        public Criteria andArrivalIndexEqualTo(Integer value) {
            addCriterion("arrival_index =", value, "arrivalIndex");
            return (Criteria) this;
        }

        public Criteria andArrivalIndexNotEqualTo(Integer value) {
            addCriterion("arrival_index <>", value, "arrivalIndex");
            return (Criteria) this;
        }

        public Criteria andArrivalIndexGreaterThan(Integer value) {
            addCriterion("arrival_index >", value, "arrivalIndex");
            return (Criteria) this;
        }

        public Criteria andArrivalIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("arrival_index >=", value, "arrivalIndex");
            return (Criteria) this;
        }

        public Criteria andArrivalIndexLessThan(Integer value) {
            addCriterion("arrival_index <", value, "arrivalIndex");
            return (Criteria) this;
        }

        public Criteria andArrivalIndexLessThanOrEqualTo(Integer value) {
            addCriterion("arrival_index <=", value, "arrivalIndex");
            return (Criteria) this;
        }

        public Criteria andArrivalIndexIn(List<Integer> values) {
            addCriterion("arrival_index in", values, "arrivalIndex");
            return (Criteria) this;
        }

        public Criteria andArrivalIndexNotIn(List<Integer> values) {
            addCriterion("arrival_index not in", values, "arrivalIndex");
            return (Criteria) this;
        }

        public Criteria andArrivalIndexBetween(Integer value1, Integer value2) {
            addCriterion("arrival_index between", value1, value2, "arrivalIndex");
            return (Criteria) this;
        }

        public Criteria andArrivalIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("arrival_index not between", value1, value2, "arrivalIndex");
            return (Criteria) this;
        }

        public Criteria andFirstClassIsNull() {
            addCriterion("first_class is null");
            return (Criteria) this;
        }

        public Criteria andFirstClassIsNotNull() {
            addCriterion("first_class is not null");
            return (Criteria) this;
        }

        public Criteria andFirstClassEqualTo(Integer value) {
            addCriterion("first_class =", value, "firstClass");
            return (Criteria) this;
        }

        public Criteria andFirstClassNotEqualTo(Integer value) {
            addCriterion("first_class <>", value, "firstClass");
            return (Criteria) this;
        }

        public Criteria andFirstClassGreaterThan(Integer value) {
            addCriterion("first_class >", value, "firstClass");
            return (Criteria) this;
        }

        public Criteria andFirstClassGreaterThanOrEqualTo(Integer value) {
            addCriterion("first_class >=", value, "firstClass");
            return (Criteria) this;
        }

        public Criteria andFirstClassLessThan(Integer value) {
            addCriterion("first_class <", value, "firstClass");
            return (Criteria) this;
        }

        public Criteria andFirstClassLessThanOrEqualTo(Integer value) {
            addCriterion("first_class <=", value, "firstClass");
            return (Criteria) this;
        }

        public Criteria andFirstClassIn(List<Integer> values) {
            addCriterion("first_class in", values, "firstClass");
            return (Criteria) this;
        }

        public Criteria andFirstClassNotIn(List<Integer> values) {
            addCriterion("first_class not in", values, "firstClass");
            return (Criteria) this;
        }

        public Criteria andFirstClassBetween(Integer value1, Integer value2) {
            addCriterion("first_class between", value1, value2, "firstClass");
            return (Criteria) this;
        }

        public Criteria andFirstClassNotBetween(Integer value1, Integer value2) {
            addCriterion("first_class not between", value1, value2, "firstClass");
            return (Criteria) this;
        }

        public Criteria andFirstClassPriceIsNull() {
            addCriterion("first_class_price is null");
            return (Criteria) this;
        }

        public Criteria andFirstClassPriceIsNotNull() {
            addCriterion("first_class_price is not null");
            return (Criteria) this;
        }

        public Criteria andFirstClassPriceEqualTo(BigDecimal value) {
            addCriterion("first_class_price =", value, "firstClassPrice");
            return (Criteria) this;
        }

        public Criteria andFirstClassPriceNotEqualTo(BigDecimal value) {
            addCriterion("first_class_price <>", value, "firstClassPrice");
            return (Criteria) this;
        }

        public Criteria andFirstClassPriceGreaterThan(BigDecimal value) {
            addCriterion("first_class_price >", value, "firstClassPrice");
            return (Criteria) this;
        }

        public Criteria andFirstClassPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("first_class_price >=", value, "firstClassPrice");
            return (Criteria) this;
        }

        public Criteria andFirstClassPriceLessThan(BigDecimal value) {
            addCriterion("first_class_price <", value, "firstClassPrice");
            return (Criteria) this;
        }

        public Criteria andFirstClassPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("first_class_price <=", value, "firstClassPrice");
            return (Criteria) this;
        }

        public Criteria andFirstClassPriceIn(List<BigDecimal> values) {
            addCriterion("first_class_price in", values, "firstClassPrice");
            return (Criteria) this;
        }

        public Criteria andFirstClassPriceNotIn(List<BigDecimal> values) {
            addCriterion("first_class_price not in", values, "firstClassPrice");
            return (Criteria) this;
        }

        public Criteria andFirstClassPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_class_price between", value1, value2, "firstClassPrice");
            return (Criteria) this;
        }

        public Criteria andFirstClassPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_class_price not between", value1, value2, "firstClassPrice");
            return (Criteria) this;
        }

        public Criteria andSecondClassIsNull() {
            addCriterion("second_class is null");
            return (Criteria) this;
        }

        public Criteria andSecondClassIsNotNull() {
            addCriterion("second_class is not null");
            return (Criteria) this;
        }

        public Criteria andSecondClassEqualTo(Integer value) {
            addCriterion("second_class =", value, "secondClass");
            return (Criteria) this;
        }

        public Criteria andSecondClassNotEqualTo(Integer value) {
            addCriterion("second_class <>", value, "secondClass");
            return (Criteria) this;
        }

        public Criteria andSecondClassGreaterThan(Integer value) {
            addCriterion("second_class >", value, "secondClass");
            return (Criteria) this;
        }

        public Criteria andSecondClassGreaterThanOrEqualTo(Integer value) {
            addCriterion("second_class >=", value, "secondClass");
            return (Criteria) this;
        }

        public Criteria andSecondClassLessThan(Integer value) {
            addCriterion("second_class <", value, "secondClass");
            return (Criteria) this;
        }

        public Criteria andSecondClassLessThanOrEqualTo(Integer value) {
            addCriterion("second_class <=", value, "secondClass");
            return (Criteria) this;
        }

        public Criteria andSecondClassIn(List<Integer> values) {
            addCriterion("second_class in", values, "secondClass");
            return (Criteria) this;
        }

        public Criteria andSecondClassNotIn(List<Integer> values) {
            addCriterion("second_class not in", values, "secondClass");
            return (Criteria) this;
        }

        public Criteria andSecondClassBetween(Integer value1, Integer value2) {
            addCriterion("second_class between", value1, value2, "secondClass");
            return (Criteria) this;
        }

        public Criteria andSecondClassNotBetween(Integer value1, Integer value2) {
            addCriterion("second_class not between", value1, value2, "secondClass");
            return (Criteria) this;
        }

        public Criteria andSecondClassPriceIsNull() {
            addCriterion("second_class_price is null");
            return (Criteria) this;
        }

        public Criteria andSecondClassPriceIsNotNull() {
            addCriterion("second_class_price is not null");
            return (Criteria) this;
        }

        public Criteria andSecondClassPriceEqualTo(BigDecimal value) {
            addCriterion("second_class_price =", value, "secondClassPrice");
            return (Criteria) this;
        }

        public Criteria andSecondClassPriceNotEqualTo(BigDecimal value) {
            addCriterion("second_class_price <>", value, "secondClassPrice");
            return (Criteria) this;
        }

        public Criteria andSecondClassPriceGreaterThan(BigDecimal value) {
            addCriterion("second_class_price >", value, "secondClassPrice");
            return (Criteria) this;
        }

        public Criteria andSecondClassPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("second_class_price >=", value, "secondClassPrice");
            return (Criteria) this;
        }

        public Criteria andSecondClassPriceLessThan(BigDecimal value) {
            addCriterion("second_class_price <", value, "secondClassPrice");
            return (Criteria) this;
        }

        public Criteria andSecondClassPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("second_class_price <=", value, "secondClassPrice");
            return (Criteria) this;
        }

        public Criteria andSecondClassPriceIn(List<BigDecimal> values) {
            addCriterion("second_class_price in", values, "secondClassPrice");
            return (Criteria) this;
        }

        public Criteria andSecondClassPriceNotIn(List<BigDecimal> values) {
            addCriterion("second_class_price not in", values, "secondClassPrice");
            return (Criteria) this;
        }

        public Criteria andSecondClassPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("second_class_price between", value1, value2, "secondClassPrice");
            return (Criteria) this;
        }

        public Criteria andSecondClassPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("second_class_price not between", value1, value2, "secondClassPrice");
            return (Criteria) this;
        }

        public Criteria andSoftSleeperIsNull() {
            addCriterion("soft_sleeper is null");
            return (Criteria) this;
        }

        public Criteria andSoftSleeperIsNotNull() {
            addCriterion("soft_sleeper is not null");
            return (Criteria) this;
        }

        public Criteria andSoftSleeperEqualTo(Integer value) {
            addCriterion("soft_sleeper =", value, "softSleeper");
            return (Criteria) this;
        }

        public Criteria andSoftSleeperNotEqualTo(Integer value) {
            addCriterion("soft_sleeper <>", value, "softSleeper");
            return (Criteria) this;
        }

        public Criteria andSoftSleeperGreaterThan(Integer value) {
            addCriterion("soft_sleeper >", value, "softSleeper");
            return (Criteria) this;
        }

        public Criteria andSoftSleeperGreaterThanOrEqualTo(Integer value) {
            addCriterion("soft_sleeper >=", value, "softSleeper");
            return (Criteria) this;
        }

        public Criteria andSoftSleeperLessThan(Integer value) {
            addCriterion("soft_sleeper <", value, "softSleeper");
            return (Criteria) this;
        }

        public Criteria andSoftSleeperLessThanOrEqualTo(Integer value) {
            addCriterion("soft_sleeper <=", value, "softSleeper");
            return (Criteria) this;
        }

        public Criteria andSoftSleeperIn(List<Integer> values) {
            addCriterion("soft_sleeper in", values, "softSleeper");
            return (Criteria) this;
        }

        public Criteria andSoftSleeperNotIn(List<Integer> values) {
            addCriterion("soft_sleeper not in", values, "softSleeper");
            return (Criteria) this;
        }

        public Criteria andSoftSleeperBetween(Integer value1, Integer value2) {
            addCriterion("soft_sleeper between", value1, value2, "softSleeper");
            return (Criteria) this;
        }

        public Criteria andSoftSleeperNotBetween(Integer value1, Integer value2) {
            addCriterion("soft_sleeper not between", value1, value2, "softSleeper");
            return (Criteria) this;
        }

        public Criteria andSoftSleeperPriceIsNull() {
            addCriterion("soft_sleeper_price is null");
            return (Criteria) this;
        }

        public Criteria andSoftSleeperPriceIsNotNull() {
            addCriterion("soft_sleeper_price is not null");
            return (Criteria) this;
        }

        public Criteria andSoftSleeperPriceEqualTo(BigDecimal value) {
            addCriterion("soft_sleeper_price =", value, "softSleeperPrice");
            return (Criteria) this;
        }

        public Criteria andSoftSleeperPriceNotEqualTo(BigDecimal value) {
            addCriterion("soft_sleeper_price <>", value, "softSleeperPrice");
            return (Criteria) this;
        }

        public Criteria andSoftSleeperPriceGreaterThan(BigDecimal value) {
            addCriterion("soft_sleeper_price >", value, "softSleeperPrice");
            return (Criteria) this;
        }

        public Criteria andSoftSleeperPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("soft_sleeper_price >=", value, "softSleeperPrice");
            return (Criteria) this;
        }

        public Criteria andSoftSleeperPriceLessThan(BigDecimal value) {
            addCriterion("soft_sleeper_price <", value, "softSleeperPrice");
            return (Criteria) this;
        }

        public Criteria andSoftSleeperPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("soft_sleeper_price <=", value, "softSleeperPrice");
            return (Criteria) this;
        }

        public Criteria andSoftSleeperPriceIn(List<BigDecimal> values) {
            addCriterion("soft_sleeper_price in", values, "softSleeperPrice");
            return (Criteria) this;
        }

        public Criteria andSoftSleeperPriceNotIn(List<BigDecimal> values) {
            addCriterion("soft_sleeper_price not in", values, "softSleeperPrice");
            return (Criteria) this;
        }

        public Criteria andSoftSleeperPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("soft_sleeper_price between", value1, value2, "softSleeperPrice");
            return (Criteria) this;
        }

        public Criteria andSoftSleeperPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("soft_sleeper_price not between", value1, value2, "softSleeperPrice");
            return (Criteria) this;
        }

        public Criteria andHardSleeperIsNull() {
            addCriterion("hard_sleeper is null");
            return (Criteria) this;
        }

        public Criteria andHardSleeperIsNotNull() {
            addCriterion("hard_sleeper is not null");
            return (Criteria) this;
        }

        public Criteria andHardSleeperEqualTo(Integer value) {
            addCriterion("hard_sleeper =", value, "hardSleeper");
            return (Criteria) this;
        }

        public Criteria andHardSleeperNotEqualTo(Integer value) {
            addCriterion("hard_sleeper <>", value, "hardSleeper");
            return (Criteria) this;
        }

        public Criteria andHardSleeperGreaterThan(Integer value) {
            addCriterion("hard_sleeper >", value, "hardSleeper");
            return (Criteria) this;
        }

        public Criteria andHardSleeperGreaterThanOrEqualTo(Integer value) {
            addCriterion("hard_sleeper >=", value, "hardSleeper");
            return (Criteria) this;
        }

        public Criteria andHardSleeperLessThan(Integer value) {
            addCriterion("hard_sleeper <", value, "hardSleeper");
            return (Criteria) this;
        }

        public Criteria andHardSleeperLessThanOrEqualTo(Integer value) {
            addCriterion("hard_sleeper <=", value, "hardSleeper");
            return (Criteria) this;
        }

        public Criteria andHardSleeperIn(List<Integer> values) {
            addCriterion("hard_sleeper in", values, "hardSleeper");
            return (Criteria) this;
        }

        public Criteria andHardSleeperNotIn(List<Integer> values) {
            addCriterion("hard_sleeper not in", values, "hardSleeper");
            return (Criteria) this;
        }

        public Criteria andHardSleeperBetween(Integer value1, Integer value2) {
            addCriterion("hard_sleeper between", value1, value2, "hardSleeper");
            return (Criteria) this;
        }

        public Criteria andHardSleeperNotBetween(Integer value1, Integer value2) {
            addCriterion("hard_sleeper not between", value1, value2, "hardSleeper");
            return (Criteria) this;
        }

        public Criteria andHardSleeperPriceIsNull() {
            addCriterion("hard_sleeper_price is null");
            return (Criteria) this;
        }

        public Criteria andHardSleeperPriceIsNotNull() {
            addCriterion("hard_sleeper_price is not null");
            return (Criteria) this;
        }

        public Criteria andHardSleeperPriceEqualTo(BigDecimal value) {
            addCriterion("hard_sleeper_price =", value, "hardSleeperPrice");
            return (Criteria) this;
        }

        public Criteria andHardSleeperPriceNotEqualTo(BigDecimal value) {
            addCriterion("hard_sleeper_price <>", value, "hardSleeperPrice");
            return (Criteria) this;
        }

        public Criteria andHardSleeperPriceGreaterThan(BigDecimal value) {
            addCriterion("hard_sleeper_price >", value, "hardSleeperPrice");
            return (Criteria) this;
        }

        public Criteria andHardSleeperPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hard_sleeper_price >=", value, "hardSleeperPrice");
            return (Criteria) this;
        }

        public Criteria andHardSleeperPriceLessThan(BigDecimal value) {
            addCriterion("hard_sleeper_price <", value, "hardSleeperPrice");
            return (Criteria) this;
        }

        public Criteria andHardSleeperPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hard_sleeper_price <=", value, "hardSleeperPrice");
            return (Criteria) this;
        }

        public Criteria andHardSleeperPriceIn(List<BigDecimal> values) {
            addCriterion("hard_sleeper_price in", values, "hardSleeperPrice");
            return (Criteria) this;
        }

        public Criteria andHardSleeperPriceNotIn(List<BigDecimal> values) {
            addCriterion("hard_sleeper_price not in", values, "hardSleeperPrice");
            return (Criteria) this;
        }

        public Criteria andHardSleeperPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hard_sleeper_price between", value1, value2, "hardSleeperPrice");
            return (Criteria) this;
        }

        public Criteria andHardSleeperPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hard_sleeper_price not between", value1, value2, "hardSleeperPrice");
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
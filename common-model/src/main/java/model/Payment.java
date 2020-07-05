package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author pdj
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {

	private static final long serialVersionUID = 1593940677103L;


	/**
	 * 主键
	 * <p>
	 * isNullAble:0
	 */
	private Long id;

	/**
	 * isNullAble:0,defaultVal:
	 */
	private String serial;


	@Override
	public String toString() {
		return "Payment{" +
				"id='" + id + '\'' +
				"serial='" + serial + '\'' +
				'}';
	}

	public static Builder Build() {
		return new Builder();
	}

	public static ConditionBuilder ConditionBuild() {
		return new ConditionBuilder();
	}

	public static UpdateBuilder UpdateBuild() {
		return new UpdateBuilder();
	}

	public static QueryBuilder QueryBuild() {
		return new QueryBuilder();
	}

	public static class UpdateBuilder {

		private Payment set;

		private ConditionBuilder where;

		public UpdateBuilder set(Payment set) {
			this.set = set;
			return this;
		}

		public Payment getSet() {
			return this.set;
		}

		public UpdateBuilder where(ConditionBuilder where) {
			this.where = where;
			return this;
		}

		public ConditionBuilder getWhere() {
			return this.where;
		}

		public UpdateBuilder build() {
			return this;
		}
	}

	public static class QueryBuilder extends Payment {
		/**
		 * 需要返回的列
		 */
		private Map<String, Object> fetchFields;

		public Map<String, Object> getFetchFields() {
			return this.fetchFields;
		}

		private List<Long> idList;

		public List<Long> getIdList() {
			return this.idList;
		}

		private Long idSt;

		private Long idEd;

		public Long getIdSt() {
			return this.idSt;
		}

		public Long getIdEd() {
			return this.idEd;
		}

		private List<String> serialList;

		public List<String> getSerialList() {
			return this.serialList;
		}


		private List<String> fuzzySerial;

		public List<String> getFuzzySerial() {
			return this.fuzzySerial;
		}

		private List<String> rightFuzzySerial;

		public List<String> getRightFuzzySerial() {
			return this.rightFuzzySerial;
		}

		private QueryBuilder() {
			this.fetchFields = new HashMap<>();
		}

		public QueryBuilder idBetWeen(Long idSt, Long idEd) {
			this.idSt = idSt;
			this.idEd = idEd;
			return this;
		}

		public QueryBuilder idGreaterEqThan(Long idSt) {
			this.idSt = idSt;
			return this;
		}

		public QueryBuilder idLessEqThan(Long idEd) {
			this.idEd = idEd;
			return this;
		}


		public QueryBuilder id(Long id) {
			setId(id);
			return this;
		}

		public QueryBuilder idList(Long... id) {
			this.idList = solveNullList(id);
			return this;
		}

		public QueryBuilder idList(List<Long> id) {
			this.idList = id;
			return this;
		}

		public QueryBuilder fetchId() {
			setFetchFields("fetchFields", "id");
			return this;
		}

		public QueryBuilder excludeId() {
			setFetchFields("excludeFields", "id");
			return this;
		}

		public QueryBuilder fuzzySerial(List<String> fuzzySerial) {
			this.fuzzySerial = fuzzySerial;
			return this;
		}

		public QueryBuilder fuzzySerial(String... fuzzySerial) {
			this.fuzzySerial = solveNullList(fuzzySerial);
			return this;
		}

		public QueryBuilder rightFuzzySerial(List<String> rightFuzzySerial) {
			this.rightFuzzySerial = rightFuzzySerial;
			return this;
		}

		public QueryBuilder rightFuzzySerial(String... rightFuzzySerial) {
			this.rightFuzzySerial = solveNullList(rightFuzzySerial);
			return this;
		}

		public QueryBuilder serial(String serial) {
			setSerial(serial);
			return this;
		}

		public QueryBuilder serialList(String... serial) {
			this.serialList = solveNullList(serial);
			return this;
		}

		public QueryBuilder serialList(List<String> serial) {
			this.serialList = serial;
			return this;
		}

		public QueryBuilder fetchSerial() {
			setFetchFields("fetchFields", "serial");
			return this;
		}

		public QueryBuilder excludeSerial() {
			setFetchFields("excludeFields", "serial");
			return this;
		}

		private <T> List<T> solveNullList(T... objs) {
			if (objs != null) {
				List<T> list = new ArrayList<>();
				for (T item : objs) {
					if (item != null) {
						list.add(item);
					}
				}
				return list;
			}
			return null;
		}

		public QueryBuilder fetchAll() {
			this.fetchFields.put("AllFields", true);
			return this;
		}

		public QueryBuilder addField(String... fields) {
			List<String> list = new ArrayList<>();
			if (fields != null) {
				for (String field : fields) {
					list.add(field);
				}
			}
			this.fetchFields.put("otherFields", list);
			return this;
		}

		@SuppressWarnings("unchecked")
		private void setFetchFields(String key, String val) {
			Map<String, Boolean> fields = (Map<String, Boolean>) this.fetchFields.get(key);
			if (fields == null) {
				fields = new HashMap<>();
			}
			fields.put(val, true);
			this.fetchFields.put(key, fields);
		}

		public Payment build() {
			return this;
		}
	}


	public static class ConditionBuilder {
		private List<Long> idList;

		public List<Long> getIdList() {
			return this.idList;
		}

		private Long idSt;

		private Long idEd;

		public Long getIdSt() {
			return this.idSt;
		}

		public Long getIdEd() {
			return this.idEd;
		}

		private List<String> serialList;

		public List<String> getSerialList() {
			return this.serialList;
		}


		private List<String> fuzzySerial;

		public List<String> getFuzzySerial() {
			return this.fuzzySerial;
		}

		private List<String> rightFuzzySerial;

		public List<String> getRightFuzzySerial() {
			return this.rightFuzzySerial;
		}

		public ConditionBuilder idBetWeen(Long idSt, Long idEd) {
			this.idSt = idSt;
			this.idEd = idEd;
			return this;
		}

		public ConditionBuilder idGreaterEqThan(Long idSt) {
			this.idSt = idSt;
			return this;
		}

		public ConditionBuilder idLessEqThan(Long idEd) {
			this.idEd = idEd;
			return this;
		}


		public ConditionBuilder idList(Long... id) {
			this.idList = solveNullList(id);
			return this;
		}

		public ConditionBuilder idList(List<Long> id) {
			this.idList = id;
			return this;
		}

		public ConditionBuilder fuzzySerial(List<String> fuzzySerial) {
			this.fuzzySerial = fuzzySerial;
			return this;
		}

		public ConditionBuilder fuzzySerial(String... fuzzySerial) {
			this.fuzzySerial = solveNullList(fuzzySerial);
			return this;
		}

		public ConditionBuilder rightFuzzySerial(List<String> rightFuzzySerial) {
			this.rightFuzzySerial = rightFuzzySerial;
			return this;
		}

		public ConditionBuilder rightFuzzySerial(String... rightFuzzySerial) {
			this.rightFuzzySerial = solveNullList(rightFuzzySerial);
			return this;
		}

		public ConditionBuilder serialList(String... serial) {
			this.serialList = solveNullList(serial);
			return this;
		}

		public ConditionBuilder serialList(List<String> serial) {
			this.serialList = serial;
			return this;
		}

		private <T> List<T> solveNullList(T... objs) {
			if (objs != null) {
				List<T> list = new ArrayList<>();
				for (T item : objs) {
					if (item != null) {
						list.add(item);
					}
				}
				return list;
			}
			return null;
		}

		public ConditionBuilder build() {
			return this;
		}
	}

	public static class Builder {

		private Payment obj;

		public Builder() {
			this.obj = new Payment();
		}

		public Builder id(Long id) {
			this.obj.setId(id);
			return this;
		}

		public Builder serial(String serial) {
			this.obj.setSerial(serial);
			return this;
		}

		public Payment build() {
			return obj;
		}
	}

}

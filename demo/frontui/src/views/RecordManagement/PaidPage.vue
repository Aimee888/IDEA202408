<!--/src/views/home.vue-->
<template>
  <el-card>
    <div class="year-month-day-filters">
      <select v-model="selectedYear">
        <option v-for="year in yearOptions" :key="year" :value="year">{{ year }}</option>
      </select>
      <div>年</div>
      <select v-model="selectedMonth">
        <option v-for="month in monthOptions" :key="month" :value="month">{{ month }}</option>
      </select>
      <div>月</div>
      <select v-model="selectedDay">
        <option v-for="day in dayOptions" :key="day" :value="day">{{ day }}</option>
      </select>
      <div>日</div>
    </div>
    <div style="height: 30px;"></div>
    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button type="primary" plain>
          <el-icon><Plus /></el-icon>
          新增
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="success" plain :disabled="single">
          <el-icon><Edit /></el-icon>
          修改
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
            type="danger"
            plain
            icon="el-icon-delete"
            size="mini"
            :disabled="multiple"
            @click="handleDelete"
            v-hasPermi="['system:role:remove']"
        >删除</el-button>
      </el-col>
    </el-row>
    <el-table
        :data="this.tablelist"
        style="width: 50%;"
        height="780px"
        @row-dblclick="handleRowDblClick"
    >
      <el-table-column label="日期" prop="col1" min-width="10%" >
      </el-table-column>
      <el-table-column label="类别" prop="col2" min-width="10%" />
      <el-table-column label="价格" prop="col3" min-width="10%" >
        <template #default="scope">
          <el-form :model="scope.row">
            <el-form-item>
              <el-input v-if="scope.row.modify" v-model="scope.row.col3" @blur="handleInputBlur(scope.row)"></el-input>
              <span v-else>{{scope.row.col3}}</span>
            </el-form-item>
          </el-form>
        </template>
      </el-table-column>
      <el-table-column label="详细描述" prop="col4" min-width="10%" />
      <el-table-column label="标签" prop="col5" min-width="10%" />
    </el-table>
  </el-card>
</template>

<script>
export default {
  data () {
    return {
      selectedYear: this.getCurrentYear(),
      selectedMonth: this.getCurrentMonth(),
      selectedDay: this.getCurrentDay(),
      yearOptions: [...Array(10).keys()].map(i => 2024 + i), // 假设从2020年开始，持续10年
      monthOptions: [...Array(12).keys()].map(i => i + 1), // 1到12月
      dayOptions: [...Array(31).keys()].map(i => i + 1), // 1到31日
      // 数据绑定对象
      tablelist: [
        {
        "col1": "2024/8/16",
        "col2": "早餐",
        "col3": "5.5",
        "col4": "",
        "col5": "",
        },
        {
          "col1": "2024/8/16",
          "col2": "晚餐",
          "col3": "12",
          "col4": "",
          "col5": "",
        },
        {
          "col1": this.getCurrentDate(),
          "col2": "",
          "col3": "",
          "col4": "",
          "col5": "",
        },
      ]
    }
  },
  methods:{
    getCurrentYear() {
      let now = new Date();
      return now.getFullYear();
    },
    getCurrentMonth() {
      let now = new Date();
      return now.getMonth() + 1;
    },
    getCurrentDay() {
      let now = new Date();
      return now.getDate();
    },
    getCurrentDate() {
      let now = new Date();
      let year = now.getFullYear();
      let month = now.getMonth() + 1;
      let day = now.getDate();
      return year + "/" + month + "/" + day;
    },
    handleRowDblClick(row, event, column) {
      row.modify = true;
    } ,
    handleInputBlur(row) {
      row.modify = false;
      // 在 Vue 3 中，由于 Proxy 的存在，通常不需要手动更新数组
      // 但如果你需要触发某种更新（例如，重新排序或过滤），你可能需要这样做
      // 这里我们不需要，因为数据已经是响应式的
    }
  }
}

</script>
<style scoped>
.el-card{
  height: 800px;
}
.year-month-day-filters {
  display: flex;
  gap: 10px; /* 调整间隔 */
}
</style>

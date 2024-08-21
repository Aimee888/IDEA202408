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
        <el-button type="primary" plain @click="addRow">
          <el-icon><Plus /></el-icon>
          新增
        </el-button>
      </el-col>
    </el-row>
    <el-table
        :data="tablelist"
        style="width: 50%;"
        height="780px"
        @selection-change="handleSelectionChange"
    >
      <el-table-column
          label="操作"
          min-width="8%">
        <template #default="scope">
          <el-tooltip content="Edit" placement="top">
            <el-button link type="primary" icon="Edit" @click="handleEdit(scope.row)"></el-button>
          </el-tooltip>
          <el-tooltip content="Remove" placement="top">
            <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)"></el-button>
          </el-tooltip>
        </template>
      </el-table-column>
      <el-table-column label="日期" prop="date" min-width="15%" >
        <template #default="scope">
          <!-- 如果行正在编辑，则显示日期选择器 -->
          <el-date-picker
              v-if="scope.row.isEditing"
              v-model="scope.row.date"
              type="date"
              placeholder="选择日期"
              format="YYYY-MM-DD"
              value-format="YYYY-MM-DD"
              style="width: 100%;"
          ></el-date-picker>
          <!-- 如果行不在编辑状态，则显示日期字符串 -->
          <span v-else>{{ scope.row.date }}</span>
        </template>
      </el-table-column>
      <el-table-column label="类别" prop="type" min-width="10%" >
        <template #default="scope">
          <el-input v-if="scope.row.isEditing" v-model="scope.row.type"></el-input>
          <span v-else>{{scope.row.type}}</span>
        </template>
      </el-table-column>
      <el-table-column label="价格" prop="price" min-width="10%" >
        <template #default="scope">
          <el-input v-if="scope.row.isEditing" v-model="scope.row.price"></el-input>
          <span v-else>{{scope.row.price}}</span>
        </template>
      </el-table-column>
      <el-table-column label="详细描述" prop="detaildescription" min-width="20%" >
        <template #default="scope">
          <el-input v-if="scope.row.isEditing" v-model="scope.row.detaildescription"></el-input>
          <span v-else>{{scope.row.detaildescription}}</span>
        </template>
      </el-table-column>
      <el-table-column label="标签" prop="tag" min-width="10%" >
        <template v-slot="scope">
          <el-select  v-if="scope.row.isEditing" v-model="scope.row.tag" value-key="paid_id" style="width: 100%" placeholder="select a type">
            <el-option :label="pro.paid_type" :value="pro.paid_id" v-for="pro in paidtype" :key="pro.paid_id" ></el-option>
          </el-select>
          <el-tag v-else :type="getStatusType(scope.row.tag)">{{ getPaidTypeName(scope.row.tag) }}</el-tag>
        </template>
      </el-table-column>
      <el-table-column min-width="10%" >
        <template #default="scope">
          <el-button v-if="scope.row.isEditing" style="background-color: #00ff7f" @click="editFinished(scope.row)">OK</el-button>
        </template>
      </el-table-column>
    </el-table>
  </el-card>
</template>

<script>
import Global from "@/components/GlobalIp.vue";

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
      tablelist: [],
      editIndexRow: null,
      editIndexColumn: null,
      paidtype: [
          {"paid_id": 1, "paid_type": "食物"},
          {"paid_id": 2, "paid_type": "日常用品"},
          {"paid_id": 3, "paid_type": "衣物"},
          {"paid_id": 4, "paid_type": "旅游"},
          {"paid_id": 5, "paid_type": "医疗"},
          {"paid_id": 6, "paid_type": "车费"},
          {"paid_id": 7, "paid_type": "人情往来"},
      ],
      addstatus: false,
    }
  },
  mounted() {
    this.getdata()
  },
  methods:{
    getdata() {
      this.$axios
          .get(Global.bg_java + '/api/getpaidlist')
          .then(successResponse => {
            console.log(successResponse.data)
            if (successResponse.data.code !== 200) {
              console.log('获取失败')
            } else {
              console.log('获取成功')
              this.tablelist = successResponse.data.data
              console.log(this.tablelist)
            }
          })
          .catch(failResponse => {
            console.log('12345566')
            console.log(failResponse)
          })
    },
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
      month = String(month).padStart(2, '0');
      day = String(day).padStart(2, '0');
      return year + "-" + month + "-" + day;
    },
    formattedDate(year, month, day) {
      let monthtmp = String(month).padStart(2, '0');
      let daytmp = String(day).padStart(2, '0');
      return `${year}-${monthtmp}-${daytmp}`;
    },
    addRow(){
      if(!this.addstatus){
        this.addstatus = true
        let defaultdate = undefined
        if(this.selectedYear !== undefined && this.selectedMonth !== undefined && this.selectedDay !== undefined){
          defaultdate = this.formattedDate(this.selectedYear, this.selectedMonth, this.selectedDay)
        }
        else{
          defaultdate = this.getCurrentDate()
        }
        this.tablelist.push({ date: defaultdate, type: '', price: '', detaildescription: '', tag: '', isEditing:true});
        console.log(this.tablelist)
      }
    },
    handleEdit(row){
      row.isEditing = true
    },
    handleDelete(row){
      let data = {
        "id": row.id
      }
      if(!this.addstatus){
        this.$axios
            .post(Global.bg_java + '/api/deletepaid', data)
            .then(successResponse => {
              console.log(successResponse.data)
              if (successResponse.data.code !== 200) {
                console.log('删除失败')
              } else {
                console.log('删除成功')
                this.tablelist = this.tablelist.filter(item => item.id !== row.id);
              }
            })
            .catch(failResponse => {
              console.log('12345566')
              console.log(failResponse)
            })
      }
      else{
        this.addstatus = false
        this.tablelist.pop();
      }

    },
    editFinished(row){
      row.isEditing = false
      let data = {
        "id": row.id,
        "date": row.date,
        "type": row.type,
        "price": row.price,
        "detaildescription": row.detaildescription,
        "tag": row.tag,
      }
      if(this.addstatus){
        this.addstatus = false
        this.$axios
            .post(Global.bg_java + '/api/addpaid', data)
            .then(successResponse => {
              console.log(successResponse.data)
              if (successResponse.data.code !== 200) {
                console.log('添加失败')
              } else {
                console.log('添加成功')
                this.getdata()
              }
            })
            .catch(failResponse => {
              console.log('12345566')
              console.log(failResponse)
            })
      }
      else{
        this.$axios
            .post(Global.bg_java + '/api/updatepaid', data)
            .then(successResponse => {
              console.log(successResponse.data)
              if (successResponse.data.code !== 200) {
                console.log('更新失败')
              } else {
                console.log('更新成功')
                this.getdata()
              }
            })
            .catch(failResponse => {
              console.log('12345566')
              console.log(failResponse)
            })
      }
    },
    getStatusType(paidId) {
      switch (paidId) {
        case 1:
          return 'success';
        case 2:
          return 'info';
        case 3:
          return 'warning';
        case 4:
          return 'danger';
        case 5:
          return 'primary';
        default:
          return '';
      }
    },
    getPaidTypeName(paidId){
      const item = this.paidtype.find(item => item.paid_id === paidId);
      // 如果没有找到，返回null或undefined，或者你可以定义一个默认值
      return item ? item.paid_type : '未知类型';
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

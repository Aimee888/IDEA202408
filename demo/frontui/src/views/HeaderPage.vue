<script>
export default {
  name: 'HeaderPage',
  data() {
    return {
      today_time: this.getCurrentDate()
    }
  },
  methods: {
    getCurrentDate() {
      let now = new Date();
      let year = now.getFullYear();
      let month = now.getMonth() + 1;
      let day = now.getDate();
      let week = now.getDay();
      let weeks = ["日","一","二","三","四","五","六"];
      let getWeek = "星期" + weeks[week];
      return year + "年" + month + "月" + day + '日' + ' ' + getWeek;
    }
  }
}

</script>

<template>
  <div>
    <div class="head">
      <span>{{ today_time }}</span>
    </div>
    <div class="line"></div>
  </div>
</template>

<style scoped>
.head{
  display: flex;
  align-items: center;
  justify-content: center;
  height: 50px;
  background: linear-gradient(-80deg,#006dcc 0%,#ffffff 100%);
}
.line{
  border-top: 1px solid hsla(0,0%,100%,.05);
  border-bottom: 1px solid rgba(0,0,0,.2);
}
</style>

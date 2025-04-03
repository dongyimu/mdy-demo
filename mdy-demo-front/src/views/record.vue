<template>
  <div class="min-h-screen bg-gray-50">
    <div class="flex max-w-[1440px] mx-auto min-h-[1024px]">
      <!-- 左侧边栏 -->
      <aside class="w-64 bg-white shadow-sm p-6 min-h-[1024px]">
        <!-- 个人信息 -->
        <div class="flex flex-col items-center mb-8">

          <div class="w-20 h-20 rounded-full overflow-hidden mb-4">

            <img :src="avatarUrl" alt="头像" class="w-full h-full object-cover" />

          </div>

          <h2 class="text-lg font-medium mb-1">清风明月</h2>

          <p class="text-gray-500 text-sm">记录生活，分享技术</p>

        </div>



        <!-- 统计数据 -->

        <div class="grid grid-cols-3 gap-4 mb-8 text-center">

          <div>

            <div class="text-lg font-medium">22</div>

            <div class="text-sm text-gray-500">文章</div>

          </div>

          <div>

            <div class="text-lg font-medium">25</div>

            <div class="text-sm text-gray-500">标签</div>

          </div>

          <div>

            <div class="text-lg font-medium">431</div>

            <div class="text-sm text-gray-500">评论</div>

          </div>

        </div>



        <!-- 文章目录 -->

        <div class="mb-8">

          <h3 class="text-lg font-medium mb-4">文章目录</h3>

          <ul class="space-y-2">

            <li v-for="(item, index) in catalog" :key="index" :class="{ 'text-blue-600': item.active }"
              class="text-gray-600 hover:text-blue-600 cursor-pointer">

              {{ item.title }}

            </li>

          </ul>

        </div>



        <!-- 技术标签 -->

        <div class="mb-8">

          <h3 class="text-lg font-medium mb-4">技术标签</h3>

          <div class="flex flex-wrap gap-2">

            <el-tag v-for="tag in tags" :key="tag" size="small" class="!rounded-button">

              {{ tag }}

            </el-tag>

          </div>

        </div>



        <!-- 最新文章 -->

        <div>

          <h3 class="text-lg font-medium mb-4">最新文章</h3>

          <div class="space-y-4">

            <div v-for="(article, index) in recentArticles" :key="index"
              class="flex items-start space-x-3 cursor-pointer hover:bg-gray-50 p-2 rounded">

              <img :src="article.image" class="w-16 h-16 object-cover rounded" :alt="article.title" />

              <div>

                <h4 class="text -sm font-medium line-clamp-2">{{ article.title }}</h4>

                <p class="text-xs text-gray-500 mt-1">{{ article.date }}</p>

              </div>

            </div>

          </div>

        </div>

      </aside>



      <!-- 主内容区 -->

      <main class="flex-1 p-6">

        <!-- Banner -->

        <div class="relative h-[300px] rounded-lg overflow-hidden mb-8">

          <img :src="bannerUrl" alt="封面" class="w-full h-full object-cover" />

          <div class="absolute inset-0 bg-gradient-to-r from-black/60 to-transparent flex items-center">

            <div class="text-white p-8">

              <h1 class="text-3xl font-bold mb-4">ZYYO - 一款个人类型 Typecho 主题</h1>

              <div class="flex items-center space-x-4">

                <el-avatar :size="32" :src="avatarUrl"></el-avatar>

                <span>清风明月</span>

                <span>2023-11-06</span>

                <span>阅读 31</span>

              </div>

            </div>

          </div>

        </div>



        <!-- 文章内容 -->

        <article class="bg-white rounded-lg p-8 shadow-sm">

          <h2 class="text-2xl font-bold mb-6">主题描述</h2>



          <div class="space-y-4 text-gray-700">

            <p>专门为个人开发的一款主题，由于惯得充着也不肯于余米卖，所以就免费发出来。</p>

            <p>三栏布局，移动端自适应，简约大气。</p>

            <p>初衷是做一款社交类型的朋友圈主题。</p>

            <p>整体仅0.4Mb，功能也都没有，根据反馈的响应。</p>

            <p>主题开箱即用，没有任何复杂的操作。</p>

          </div>



          <h2 class="text-2xl font-bold mt-8 mb-6">主题预览</h2>

          <div class="grid grid-cols-2 gap-6">

            <img v-for="(preview, index) in previews" :key="index" :src="preview" class="w-full rounded-lg shadow-sm" />

          </div>

        </article>

      </main>

    </div>

  </div>

</template>



<script lang="ts" setup>

import { ref } from 'vue';



const avatarUrl = 'https://ai-public.mastergo.com/ai/img_res/e887ba2e4f97471cfa3661ac17512727.jpg';



const bannerUrl = 'https://ai-public.mastergo.com/ai/img_res/92e07ab7ac9ad64a672f1faa0b5db622.jpg';



const catalog = ref([

  { title: '主题描述', active: true },

  { title: '功能特点', active: false },

  { title: '安装说明', active: false },

  { title: '更新日志', active: false },

]);



const tags = ref(['HTML', 'CSS', 'PHP', 'JavaScript', 'TypeScript', 'Vue.js', 'React', 'Node.js']);



const recentArticles = ref([

  {

    title: '如何打造一个高性能的 Web 应用',

    date: '2025-04-02',

    image: 'https://ai-public.mastergo.com/ai/img_res/79a30b89290d0df30f2a8c0c7b5e1fb1.jpg'

  },

  {

    title: '前端工程化实践指南',

    date: '2025-03-28',

    image: 'https://ai-public.mastergo.com/ai/img_res/6ba9f382100655e1f064d73a4af3e37b.jpg'

  },

  {

    title: 'TypeScript 高级特性详解',

    date: '2025-03-15',

    image: 'https://ai-public.mastergo.com/ai/img_res/50f486d57241a010f4a259226bb6a7f4.jpg'

  }

]);



const previews = ref([

  'https://ai-public.mastergo.com/ai/img_res/2d7801ad2a33ab2e46812e354c30de57.jpg',

  'https://ai-public.mastergo.com/ai/img_res/322bf99598463ffd57a3998c0d33e35b.jpg',

]);

</script>



<style scoped>
@import "tailwindcss";

.line-clamp-2 {

  display: -webkit-box;

  -webkit-line-clamp: 2;

  -webkit-box-orient: vertical;

  overflow: hidden;

}
</style>

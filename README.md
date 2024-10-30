# پیام رسان قزمیت :)
این یک برنامه خیلی کوچکی است که هر دوست عزیزی با هر سوادی (حتی سواد اول دبستان .. خخخ) می‌تواند بنویسد. ما قصد داریم این برنامه را به منظور یادگیری اصول شی گرایی به صورت عملی در اختیار دانشجویان عزیز و فرهیخته ای که در دانشکده مهندسی کامپیوتر و در بهار 1403 درس آز مهندسی نرم افزار را اخذ کرده اند قرار دهیم تا آن را اصلاح کنند.
<table dir='rtl'>
<tbody>
<tr>
<td width="64">
<p><strong>ردیف</strong></p>
</td>
<td width="198">
<p><strong>محل اعمال تغییرات (کلاس/واسط)</strong></p>
</td>
<td width="141">
<p><strong>عنوان تغییر</strong></p>
</td>
<td width="292">
<p><strong>شرحی کوتاه از تغییر</strong></p>
</td>
</tr>
<tr>
<td width="64">
<p><strong>۱</strong></p>
</td>
<td width="198">
<p>MessageService</p>
</td>
<td width="141">
<p>افزودن تابع ارسال پیام تلگرامی</p>
</td>
<td width="292">
<p>افزودن یک تابع void با عنوان sendTelegramMessage</p>
</td>
</tr>

<tr>
<td width="64">
<p><strong>۲</strong></p>
</td>
<td width="198">
<p>TelegramMessage</p>
</td>
<td width="141">
<p>افزودن کلاس مربوط به پیام های تلگرامی</p>
</td>
<td width="292">
<p>فزودن کلاس TelegramMessage و اضافه کردن متغیرهای آن و تعریف setter و getter برای آنها</p>
</td>
</tr>
<tr>
<td width="64">
<p><strong>۳</strong></p>
</td>
<td width="198">
<p>EmailMessageService</p>
</td>
<td width="141">
<p>افزودن تابع sendTelegramMessage</p>
</td>
<td width="292">
<p>چون این کلاس، کلاس MessageService را implement میکند، باید تابع sendTelegramMessage در این کلاس نیز وجود داشته باشد.</p>
</td>
</tr>
<tr>
<td width="64">
<p><strong>۴</strong></p>
</td>
<td width="198">
<p>SmsMessageService</p>
</td>
<td width="141">
<p>افزودن تابع sendTelegramMessage</p>
</td>
<td width="292">
<p>چون این کلاس، کلاس MessageService را implement میکند، باید تابع sendTelegramMessage در این کلاس نیز وجود داشته باشد.</p>
</td>
</tr>
<tr>
<td width="64">
<p><strong>۵</strong></p>
</td>
<td width="198">
<p>TelegramMessageService</p>
</td>
<td width="141">
<p>پیاده سازی کلاس sendTelegramMessage</p>
</td>
<td width="292">
<p>افزودن و پیاده سازی توابع sendSmsMessage, sendEmailMessage, sendTelegramMessage, validatePhoneNumber</p>
</td>
</tr>

</tbody>
</table>

مجموع تعداد تغییرات: ۵
